package ru.pa4ok.demoexam;

import java.util.*;

public class Library {
    private String address;
    private Set<Book> books;

    public Library(String address, Set<Book> books) {
        this.address = address;
        this.books = books;
    }

    public List<Book> getSortedById()
    {
        List<Book> list = new ArrayList<>(books);
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
        return list;
    }

    public List<Book> getSortedByTitle()
    {
        List<Book> list = new ArrayList<>(books);
        Collections.sort(list, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
        return list;
    }

    public List<Book> getSortedByPages()
    {
        List<Book> list = new ArrayList<>(books);
        Collections.sort(list, (o1, o2) -> Integer.compare(o1.getPages(), o2.getPages()));
        return list;
    }

    public List<Book> getAuthorBooks(String author)
    {
        //List<Book> list = new ArrayList<>(books);
        //list.removeIf(book -> !book.getAuthor().equals(author));

        List<Book> list = new ArrayList<>();
        for(Book book : books) {
            if(book.getAuthor().equals(author)) {
                list.add(book);
            }
        }

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
