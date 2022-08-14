
/*
 esta clase es la estructura del nodo en el árbol AVL
 */
public class Node<TYPE extends Comparable<? super TYPE>> {
	// cada nodo tiene una altura, datos y un hijo izquierdo y derecho
	private int height;
	private Node<TYPE> left, right;
	private TYPE value;

	public Node(TYPE value) {
		this.value = value;
		height = 1;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node<TYPE> getLeft() {
		return left;
	}

	public void setLeft(Node<TYPE> left) {
		this.left = left;
	}

	public Node<TYPE> getRight() {
		return right;
	}

	public void setRight(Node<TYPE> right) {
		this.right = right;
	}

	public TYPE getValue() {
		return value;
	}

	public void setValue(TYPE value) {
		this.value = value;
	}

}