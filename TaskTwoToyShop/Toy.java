package TaskTwoToyShop;

import java.util.Objects;

public class Toy implements Comparable<Toy> {

    private int toyId;
    private String toyTitle;
    private int frequencyFallToy;

    public Toy(int toyId, String toyTitle, int frequencyFallToy) {
        this.toyId = toyId;
        this.toyTitle = toyTitle;
        this.frequencyFallToy = frequencyFallToy;
    }

    public int getToyId() {
        return toyId;
    }

    public String getToyTitle() {
        return toyTitle;
    }

    public int getFrequencyFallToy() {
        return frequencyFallToy;
    }

    public void setFrequencyFallToy(int frequencyFallToy) {
        this.frequencyFallToy = frequencyFallToy;
    }

    public String getInfo() {
        return String.format("ID: %d, Title: %s", toyId, toyTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return toyTitle.equals(toy.toyTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toyTitle);
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.frequencyFallToy, o.frequencyFallToy);
    }
}