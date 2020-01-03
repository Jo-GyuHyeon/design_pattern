package flyweight.sample.sharedtree;

public class TreeFactory {
    private static final TreeModel sharedTreeModel = new TreeModel();

    static public Tree create(Position position, double height, double thickness) {
        Tree tree = new Tree();
        tree.setPosition(position);
        tree.setHeight(height);
        tree.setThickness(thickness);
        tree.setTreeModel(sharedTreeModel);

        return tree;
    }
}
