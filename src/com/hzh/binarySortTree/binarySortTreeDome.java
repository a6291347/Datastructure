package com.hzh.binarySortTree;

public class binarySortTreeDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
		BinarySortTree bb=new BinarySortTree();
		for(int i=0;i<arr.length;i++){
			bb.add(new Node(arr[i]));
		}
		System.out.println("����ǰ");
		bb.infixorder();
		bb.delNode(7);
		System.out.println("���Ժ�");
		bb.infixorder();

	}

}
//��������������
class BinarySortTree {
	private Node root;

	// ��ӽڵ�
	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	// ��������
	public void infixorder() {
		if (root == null) {
			System.out.println("��ǰ��Ϊ�գ��޷�����");
		} else {
			root.infixOreder();
		}
	}

	// ���Ҵ�ɾ���Ľڵ�
	public Node searchDel(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchDel(val);
		}
	}

	// ���Ҵ�ɾ���ĸ��ڵ�
	public Node searchParent(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(val);
		}
	}

	// ���ҵ�ǰ�ڵ�����������С��Ԫ�ص�ֵ
	public int delRightTreeMin(Node node) {
		Node temp = node;
		while (temp.left != null) {
			temp = temp.left;
		}
		delNode(temp.val);
		return temp.val;
	}

	// ɾ���ڵ�
	// ���� 1.��ǰɾ���ڵ�ΪҶ�ӽڵ� 2.��ǰ�ڵ�Ϊ��Ҷ�ӽڵ㣨ֻ��һ��Ҷ�ӽڵ㣩
	// 3.��ǰ�ڵ�Ϊ��Ҷ�ӽڵ㣨������Ҷ�ӽڵ㣩
	public void delNode(int value) {
		// �жϵ�ǰ���Ƿ����
		if (root == null) {
			System.out.println("�������޷����в���");
			return;
		} else {
			// Ѱ����Ҫɾ���Ľڵ�
			Node searchDel = searchDel(value);
			// Ϊ����ֹ��������ǰ��û�и�Ԫ�أ�
			if (searchDel == null) {
				return;
			}
			if (root.left == null && root.right == null) {// ��ɾԪ��Ϊ���ڵ�
				root = null;
				return;
			}
			// 1.�����ɾԪ��ΪҶ�ӽڵ�
			// Ѱ�Ҵ�ɾԪ�صĸ��׽ڵ�
			Node Parent = searchParent(value);
			if (searchDel.left == null && searchDel.right == null) {
				if (Parent.left != null && searchDel.val == Parent.left.val) {
					Parent.left = null;

				} else if (Parent.right != null && searchDel.val == Parent.right.val) {
					Parent.right = null;
				}
			} else if (searchDel.left != null && searchDel.right != null) {// ��ǰ�ڵ�Ϊ��Ҷ�ӽڵ㣨������Ҷ�ӽڵ㣩
				int min = delRightTreeMin(searchDel.right);
				searchDel.val = min;
			} else {// ��ǰ�ڵ�Ϊ��Ҷ�ӽڵ㣨��һ��Ҷ�ӽڵ㣩
				if (searchDel.left != null) {// �����ӽڵ�
					if (Parent != null) {
						if (Parent.left.val == searchDel.val) {
							Parent.left = searchDel.left;
						} else {
							Parent.right = searchDel.left;
						}
					} else {
						root = searchDel.left;
					}
				} else {
					if (Parent != null) {
						if (Parent.left.val == searchDel.val) {
							Parent.left = searchDel.right;
						} else {
							Parent.right = searchDel.right;
						}
					} else {
						root = searchDel.right;
					}
				}

			}
		}

	}

}

// �����ڵ�
class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + "]";
	}

	// �ݹ����
	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.val < this.val) {
			if (this.left != null) {
				this.left.add(node);
			} else {
				this.left = node;
			}
		} else {
			if (this.right != null) {
				this.right.add(node);
			} else {
				this.right = node;
			}
		}
	}

	// �������
	public void infixOreder() {
		if (this.left != null) {
			this.left.infixOreder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOreder();
		}
	}

	// Ѱ�Ҵ�ɾ���ڵ�
	public Node searchDel(int val) {
		if (this.val == val) {
			return this;
		}
		if (val < this.val) {
			if (this.left != null) {
				return this.left.searchDel(val);
			} else {
				return null;
			}
		} else {
			if (this.right != null) {
				return this.right.searchDel(val);
			} else {
				return null;
			}
		}
	}

	// Ѱ�Ҵ�ɾ���ĸ��ڵ�
	public Node searchParent(int value) {
		// �����ǰ������Ҫɾ���Ľ��ĸ���㣬�ͷ���
		if ((this.left != null && this.left.val == value) || (this.right != null && this.right.val == value)) {
			return this;
		} else {
			// ������ҵ�ֵС�ڵ�ǰ����ֵ, ���ҵ�ǰ�������ӽ�㲻Ϊ��
			if (value < this.val && this.left != null) {
				return this.left.searchParent(value); // ���������ݹ����
			} else if (value >= this.val && this.right != null) {
				return this.right.searchParent(value); // ���������ݹ����
			} else {
				return null; // û���ҵ������
			}
		}

	}

}
