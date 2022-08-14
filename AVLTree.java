

/**
 
esta clase es la implementaci�n del �rbol avl con el m�todo de inserci�n
 que permiten agregar un nuevo nodo al �rbol
 */
public class AVLTree<TYPE extends Comparable<? super TYPE>> {

	private Node<TYPE> root;

	public Node<TYPE> getRoot() {
		return root;
	}

	public void setRoot(Node<TYPE> root) {
		this.root = root;
	}

	// este m�todo devuelve la altura del nodo actual
	public int height(Node<TYPE> node) {
		if (node == null)
			return 0;

		return node.getHeight();
	}

	// este m�todo devuelve el valor m�ximo de dos n�meros (dos alturas)
	public int max(int n1, int n2) {
		return Math.max(n1, n2);
		// return (n1 > n2) ? n1 : n2;
	}

	// este m�todo gira a la derecha el nodo desequilibrado
	public Node<TYPE> rightRotate(Node<TYPE> current) {
		Node<TYPE> temp = current.getLeft();
		Node<TYPE> T2 = temp.getRight();

		temp.setRight(current);
		current.setLeft(T2);

		// update the height after rotation
		current.setHeight(max(height(current.getLeft()), height(current.getRight())) + 1);
		temp.setHeight(max(height(temp.getLeft()), height(temp.getRight())) + 1);

		return temp;
	}

	// este m�todo gira hacia la izquierda el nodo desequilibrado
	public Node<TYPE> leftRotate(Node<TYPE> current) {
		Node<TYPE> temp = current.getRight();
		Node<TYPE> T2 = temp.getLeft();

		temp.setLeft(current);
		current.setRight(T2);

		// actualiza la altura despu�s de la rotaci�n
		current.setHeight(max(height(current.getLeft()), height(current.getRight())) + 1);
		temp.setHeight(max(height(temp.getLeft()), height(temp.getRight())) + 1);

		return temp;
	}

	public Node<TYPE> insert(Node<TYPE> current, TYPE value) {

		// inserta el nuevo valor
		if (current == null)
			return (new Node<TYPE>(value));

		if (value.compareTo(current.getValue()) < 0)
			current.setLeft(insert(current.getLeft(), value));
		else if (value.compareTo(current.getValue()) > 0)
			current.setRight(insert(current.getRight(), value));
		else // salir si el nodo ya existe
			return current;

		// actualizar altura
		current.setHeight(1 + max(height(current.getLeft()), height(current.getRight())));

		// verifique el saldo despu�s de agregar el nuevo nodo para verificar si el �rbol se convirti�
		// desequilibrada (menor que -1 o mayor que 1)
		int balance = getBalance(current);

		// si el saldo es mayor que 1, entonces procesa la rotaci�n a la derecha
		if (balance > 1 && value.compareTo(current.getLeft().getValue()) < 0)
			return rightRotate(current);

		// si el saldo es menor que -1, entonces procesa la rotaci�n a la izquierda
		if (balance < -1 && value.compareTo(current.getRight().getValue()) > 0)
			return leftRotate(current);

		// LR rotation
		if (balance > 1 && value.compareTo(current.getLeft().getValue()) > 0) {
			current.setLeft(leftRotate(current.getLeft()));
			return rightRotate(current);
		}

		// RL rotation
		if (balance < -1 && value.compareTo(current.getRight().getValue()) < 0) {
			current.setRight(rightRotate(current.getRight()));
			return leftRotate(current);
		}

		return current;
	}

	// este m�todo devuelve el saldo del nodo actual
	public int getBalance(Node<TYPE> node) {
		if (node == null)
			return 0;

		return height(node.getLeft()) - height(node.getRight());
	}

	public Node<TYPE> find(AVLTree<TYPE> tree, TYPE v) {
		Node<TYPE> current = tree.root;
		while (current != null && (current.getValue().compareTo(v) > 0 || current.getValue().compareTo(v) < 0)) {

			if (v.compareTo(current.getValue()) > 0)
				current = current.getRight();
			else
				current = current.getLeft();
		}

		return current;
	}

}