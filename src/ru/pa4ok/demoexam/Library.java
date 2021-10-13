package ru.pa4ok.demoexam;

import java.util.*;

public class Library
{
    private String address;
    private Set<Book> books;

    public Library(String address, Set<Book> books) {
        this.address = address;
        this.books = books;
    }

    public List<Book> getSortedById()
    {
        List<Book> copy = new ArrayList<>(books);

        Collections.sort(copy, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        return copy;
    }

    public List<Book> getSortedByTitle()
    {
        List<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        return copy;
    }

    public List<Book> getSortedByPages()
    {
        List<Book> copy = new ArrayList<>(books);
        Collections.sort(copy, (o1, o2) -> Integer.compare(o1.getPage(), o2.getPage()));
        return copy;
    }

    public List<Book> getAuthorBooks(String author)
    {
        /*List<Book> list = new ArrayList<>();
        for(Book b : books) {
            if(b.getAuthor().equals(author)) {
                list.add(b);
            }
        }*/

        List<Book> list = new ArrayList<>(books);
        list.removeIf(book -> !book.getAuthor().equals(author));

        return list;
    }


    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                ", books=" + books +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
