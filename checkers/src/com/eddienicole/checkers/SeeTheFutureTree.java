package com.eddienicole.checkers;

import java.util.ArrayList;

public class SeeTheFutureTree {

	private class FutureNode {
		private final ArrayList<FutureNode> children;
		private final FutureNode parent;
		private final ImaginaryBoard theBoard;

		public FutureNode(ImaginaryBoard theBoard, FutureNode parent) {
			this.theBoard = theBoard;
			this.parent = parent;
			this.children = new ArrayList<>();
		}

	}

	private final int LAYERS = 6;
	private final FutureNode root;
	private final AbstractAI theThinkingMan;

	public SeeTheFutureTree(ImaginaryBoard theBoard, AbstractAI theThinkingMan) {
		this.root = new FutureNode(theBoard, null);
		this.theThinkingMan = theThinkingMan;

		this.getChildren(this.root, this.LAYERS, this.theThinkingMan.isRed);
	}

	public MoveInterface getTheBestMove() {
		return this.minimax(this.root, this.LAYERS, true).getTheMove();
	}

	private ImaginaryBoard generateBoardBasedOnMove(MoveInterface moveToApply,
			ImaginaryBoard previousBoard) {
		ImaginaryBoard theImaginaryBoardToReturn = new ImaginaryBoard(
				previousBoard, moveToApply);

		PlayableSpaceInterface fromSpace = theImaginaryBoardToReturn
				.getSpaceByPosition(moveToApply.getFrom().getPosition());
		PlayableSpaceInterface toSpace = theImaginaryBoardToReturn
				.getSpaceByPosition(moveToApply.getTo().getPosition());

		if (moveToApply.isJump()) {
			PlayableSpaceInterface jumpedSpace = theImaginaryBoardToReturn
					.getSpaceByPosition(moveToApply.getJumped().getPosition());
			jumpedSpace.setState(SpaceState.UNOCCUPIED);
			jumpedSpace.setKing(false);
		}

		toSpace.setState(fromSpace.getState());
		toSpace.setKing(fromSpace.isKing());

		fromSpace.setState(SpaceState.UNOCCUPIED);
		fromSpace.setKing(false);

		theImaginaryBoardToReturn.setValue(this.theThinkingMan
				.evaluateBoard(theImaginaryBoardToReturn));
		return theImaginaryBoardToReturn;
	}

	private void getChildren(FutureNode node, int depthToGo, boolean isRed) {
		if (depthToGo > 0) {
			ArrayList<MoveInterface> moves = MoveFigurerOuter.figure(
					node.theBoard.getPlayableSpaces(), isRed);
			int numMoves = moves.size();
			for (int i = 0; i < numMoves; i++) {
				node.children.add(new FutureNode(this.generateBoardBasedOnMove(
						moves.get(i), node.theBoard), node));
			}
			for (FutureNode child : node.children) {
				this.getChildren(child, depthToGo - 1, !isRed);
			}

		}
	}

	private ImaginaryBoard minimax(FutureNode node, int depthToGo,
			boolean thePlayer) {
		if ((depthToGo == 0) || (node.children.size() == 0)) {
			return node.theBoard;
		}
		if (thePlayer) {
			ImaginaryBoard bestBoard = node.children.get(0).theBoard;
			for (FutureNode child : node.children) {
				child.theBoard.setValue(this.minimax(child, depthToGo - 1,
						!thePlayer).getValue());
				bestBoard = child.theBoard.compareTo(bestBoard) > 0 ? child.theBoard
						: bestBoard;
			}
			return bestBoard;
		} else {
			ImaginaryBoard bestBoard = node.children.get(0).theBoard;
			for (FutureNode child : node.children) {
				child.theBoard.setValue(this.minimax(child, depthToGo - 1,
						!thePlayer).getValue());
				bestBoard = child.theBoard.compareTo(bestBoard) < 0 ? child.theBoard
						: bestBoard;
			}
			return bestBoard;
		}
	}
}