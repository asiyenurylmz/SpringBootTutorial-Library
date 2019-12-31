package com.tutorial.library.init;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.repository.BookRepository;
import com.tutorial.library.service.BookEntityService;
import com.tutorial.library.service.CustomerEntityService;
import com.tutorial.library.service.LibraryEntityService;
import com.tutorial.library.service.StockInformationEntityService;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DatabaseInitializer implements CommandLineRunner {
	@Autowired
	private BookEntityService bookService;
	@Autowired
	private LibraryEntityService libraryService;

	@Autowired
	private CustomerEntityService customerService;
	@Autowired
	private StockInformationEntityService stockService;

	
	@SuppressWarnings("null")
	@Override
	public void run(String... args) throws Exception {
//		BookEntity book03 = new BookEntity();
//		book03.setName("Book03");
//		book03.setAuthor("Author03");
//		book03 = bookService.save(book03);
//
//		BookEntity book02 = new BookEntity();
//		book02.setName("Book02");
//		book02.setAuthor("Author02");
//		book02 = bookService.save(book02);
//
//		LibraryEntity library02 = new LibraryEntity();
//		library02.setName("Library02");
//		library02.setCity("TRABZON");
//		library02.setDistrict("ARSİN");
//	//	booksInTheLibrary.add(bookService.findById(1));
////		library01.setBooksInTheLibrary(booksInTheLibrary);
//		library02 = libraryService.save(library02);

//		List<BookEntity> booksInTheLibrary=null;
//		Optional<BookEntity> optionalBook01 = bookService.findById(1);
//		System.out.println("***************************************************");
//		if(optionalBook01.isPresent()) {
//			booksInTheLibrary.add(bookService.findById(1).get());
//			log.info((bookService.findById(1).get().toString()));
//		}
//		List<BookEntity> bookList=(List<BookEntity>) bookService.findById(1).get();
//		library02.setBooksInTheLibrary(bookList);
//		library02=libraryService.save(library02);
//	//	library01.setBooksInTheLibrary(booksInTheLibrary);

//		BookEntity bookNew = new BookEntity();
//		bookNew.setAuthor(bookService.findByName("Book01").get().getAuthor());
//		System.out.println(bookNew.toString());
//		bookNew.setName(bookService.findByName("Book01").get().getName());
//		bookNew = bookService.save(bookNew);

//		libraryService.findByCityAndDistrict("TRABZON", "ARSİN").get(0)
//				.setBooksInTheLibrary((List<BookEntity>) bookService.findByName("Book01").get());
//		libraryService.save(libraryService.findByCityAndDistrict("TRABZON", "ARSİN").get(0));
//		bookService.findByName("Book01").get()) = bookService.save(bookService.findByName("Book01").get());

		// List<BookEntity> bookList= (List<BookEntity>)
		// bookService.findByName("Book01").orElseThrow(EntityNotFoundException::new);
//////////////////////////////
		
//		List<LibraryEntity> libraries = libraryService.findByCityAndDistrict("TRABZON", "AKÇAABAT");
//		BookEntity book = bookService.findByName("Book03").orElseThrow(EntityNotFoundException::new);
//		book.setLibrariesHaveTheBook(libraries);
//		book=bookService.save(book);
		
	/*	
		BookEntity book = bookService.findByName("Book03").orElseThrow(EntityNotFoundException::new);
	
		List<LibraryEntity> libraries=book.getLibrariesHaveTheBook();
		libraries.add(libraryService.findByCityAndDistrict("TRABZON", "ARSİN").get(0));
		libraries.add(libraryService.findByCityAndDistrict("TRABZON", "AKÇAABAT").get(0));
		book.setLibrariesHaveTheBook(libraries);
		
		book=bookService.save(book);
	*/	
//		book.setLibrariesHaveTheBook((List<LibraryEntity>) libraryService.findByCityAndDistrict("TRABZON", "AKÇAABAT").get(1));
//		book=bookService.save(book);
	
		
		

//
//		LibraryEntity library02 = new LibraryEntity();
//		library02.setName("Library02");
//		library02.setCity("TRABZON");
//		library02.setDistrict("AKÇAABAT");
//		library02 = libraryService.save(library02);

//		Optional<BookEntity> optionalBook01 = bookService.findByName("Book01");
//		if (optionalBook01.isPresent()) {
//			BookEntity book01 = optionalBook01.get();
//		}
//
//		BookEntity book01 = bookService.findByName("Book01").orElseThrow(EntityNotFoundException::new);
//		System.out.println(book01.getName());

//		List<LibraryEntity> libraryList = libraryService.findByCity("TRABZON");

//		book01.setLibraries(libraryList);
//		book01 = bookService.save(book01);

//		System.out.println(Arrays.asList(libraryList.get(0).getBooks()).toString());
//		log.info("fİNİSHED");

//		CustomerEntity customer02= new CustomerEntity();
//		customer02.setName("Customer02");
//		customer02.setEmail("customer02@gmail.com");
//		customer02.setPhoneNumber((long) 1000000000);
//		customer02.setCreatedAt(LocalDateTime.now());
//		customer02 =customerService.save(customer02);
	}
}
