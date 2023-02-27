package org.bupt.fedraft.beans;

public class Tuple<L, R> {
    private L left;
    private R right;

    public Tuple(L l, R r) {
        setTuple(l, r);
    }

    public void setTuple(L l, R r) {
        setLeft(l);
        setRight(r);
    }

    public L getLeft() {
        return left;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "<" + left + ", " + right + ">";
    }
}
