public class Node {
    private int key;
    private String value;

    public Node(int key, String value){
        this.key = key;
        this.value = value;
    }

    // key 값과 value 값의 getter & setter 구현
    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    public void setKey(int key){
        this.key = key;
    }

    public void setValue(String value){
        this.value = value;
    }

    // 출력 시 필요한 "key, value" string 구현
    public String toString(){
        return this.key + "," + this.value;
    }

}
