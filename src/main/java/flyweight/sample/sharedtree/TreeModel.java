package flyweight.sample.sharedtree;

// 공유할 객체를 감쌀 나무모델 클래스를 정의
public class TreeModel {
    Mesh mesh;
    Texture bark;
    Texture leaves;

    public TreeModel() {
        this.mesh = new Mesh();
        this.bark = new Texture("bark");
        this.leaves = new Texture("leaves");
    }
}
