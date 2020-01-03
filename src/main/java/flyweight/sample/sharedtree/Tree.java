package flyweight.sample.sharedtree;

// 실제로 매번 생성할 나무 클래스를 정의한다.
public class Tree {
    TreeModel treeModel;
    Position position;
    double height;
    double thickness;

    public void setTreeModel(TreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}

class Mesh {
}

class Texture {
    String name;

    public Texture(String name) {
        this.name = name;
    }
}

class Position {
}

class Color {
}
