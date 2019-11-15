package com.hzh.binarySortTree;

public class binarySortTreeDome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
		BinarySortTree bb=new BinarySortTree();
		for(int i=0;i<arr.length;i++){
			bb.add(new Node(arr[i]));
		}
		System.out.println("测试前");
		bb.infixorder();
		bb.delNode(7);
		System.out.println("测试后");
		bb.infixorder();

	}

}
//创建二叉排序树
class BinarySortTree {
	private Node root;

	// 添加节点
	public void add(Node node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	// 中序排序
	public void infixorder() {
		if (root == null) {
			System.out.println("当前树为空，无法遍历");
		} else {
			root.infixOreder();
		}
	}

	// 查找待删除的节点
	public Node searchDel(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchDel(val);
		}
	}

	// 查找待删除的父节点
	public Node searchParent(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(val);
		}
	}

	// 查找当前节点右子树中最小的元素的值
	public int delRightTreeMin(Node node) {
		Node temp = node;
		while (temp.left != null) {
			temp = temp.left;
		}
		delNode(temp.val);
		return temp.val;
	}

	// 删除节点
	// 考虑 1.当前删除节点为叶子节点 2.当前节点为非叶子节点（只带一个叶子节点）
	// 3.当前节点为非叶子节点（带两个叶子节点）
	public void delNode(int value) {
		// 判断当前树是否存在
		if (root == null) {
			System.out.println("空树，无法进行操作");
			return;
		} else {
			// 寻找需要删除的节点
			Node searchDel = searchDel(value);
			// 为空终止操作（当前树没有该元素）
			if (searchDel == null) {
				return;
			}
			if (root.left == null && root.right == null) {// 待删元素为根节点
				root = null;
				return;
			}
			// 1.如果待删元素为叶子节点
			// 寻找待删元素的父亲节点
			Node Parent = searchParent(value);
			if (searchDel.left == null && searchDel.right == null) {
				if (Parent.left != null && searchDel.val == Parent.left.val) {
					Parent.left = null;

				} else if (Parent.right != null && searchDel.val == Parent.right.val) {
					Parent.right = null;
				}
			} else if (searchDel.left != null && searchDel.right != null) {// 当前节点为非叶子节点（带两个叶子节点）
				int min = delRightTreeMin(searchDel.right);
				searchDel.val = min;
			} else {// 当前节点为非叶子节点（带一个叶子节点）
				if (searchDel.left != null) {// 有左子节点
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

// 创建节点
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

	// 递归添加
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

	// 中序遍历
	public void infixOreder() {
		if (this.left != null) {
			this.left.infixOreder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOreder();
		}
	}

	// 寻找待删除节点
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

	// 寻找待删除的父节点
	public Node searchParent(int value) {
		// 如果当前结点就是要删除的结点的父结点，就返回
		if ((this.left != null && this.left.val == value) || (this.right != null && this.right.val == value)) {
			return this;
		} else {
			// 如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
			if (value < this.val && this.left != null) {
				return this.left.searchParent(value); // 向左子树递归查找
			} else if (value >= this.val && this.right != null) {
				return this.right.searchParent(value); // 向右子树递归查找
			} else {
				return null; // 没有找到父结点
			}
		}

	}

}
