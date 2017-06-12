package jgrapht;

/**
 * Created by viacheslav on 6/12/17.
 */
public class CustomVertex {
    private String id;
    private Color color;

    public CustomVertex(String id, Color color) {
        this.id = id;
        this.color = color;
    }

    public CustomVertex(String id) {
        this(id, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int hashCode()
    {
        return (id == null) ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomVertex other = (CustomVertex) obj;
        if (id == null) {
            return other.id == null;
        } else {
            return id.equals(other.id);
        }
    }

    @Override
    public String toString() {
        return "CustomVertex{" +
                "id=" + id +
                ", color=" + color +
                '}';
    }
}
