package com.app.bookstoreapi.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(
        name="Book.findByTitle",
        query="select b from Book b where b.title=:title"
    )
})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String author;
    Double price;
    String isbn;
	public Object getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setAuthor(Object author2) {
		// TODO Auto-generated method stub
		
	}
	public Object getIsbn() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setIsbn(Object isbn2) {
		// TODO Auto-generated method stub
		
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPrice(Object price2) {
		// TODO Auto-generated method stub
		
	}
	public void setTitle(String title2) {
		// TODO Auto-generated method stub
		
	}    
}