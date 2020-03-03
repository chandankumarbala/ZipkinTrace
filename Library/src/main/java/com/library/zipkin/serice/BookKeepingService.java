package com.library.zipkin.serice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.zipkin.dao.BookRepository;
import com.library.zipkin.entity.Book;
import com.library.zipkin.entity.BookContentDetails;
import com.library.zipkin.entity.BookInfo;

import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookKeepingService {

	@Autowired
	private BookRepository bookKeeper;

	@Autowired
	@Qualifier("book")
	private RestTemplate restCaller;
	
	
	@Value("${dealer.url}")
	private String dealer;
	
	  public List<Book> getAllBooks(){ 
		  Iterable<Book> allBooks=this.bookKeeper.findAll(); 
		  List<Book> booksMetaInfo=new ArrayList<>();
		  allBooks.iterator().forEachRemaining(book ->{
			  booksMetaInfo.add(book);
		  });
		 return booksMetaInfo;
	  }
	  
	  public BookInfo  getBookById(int id){ 
		  Optional<Book> libInfo=this.bookKeeper.findById(Long.valueOf(String.valueOf(id))) ;
		if(libInfo.isEmpty())
			return null;
		
		String uri=new StringBuffer(dealer).append("/id/").append(id).toString();
		log.info("Calling {}",uri);
		BookContentDetails content=restCaller.getForObject(uri, BookContentDetails.class);
		
		BookInfo info=new BookInfo(content,libInfo.get());
		 return info;
	  }
	 

	public boolean dumpData() {
		String bookList = "[\n" + "  {\n" + "    \"id\": \"918195\",\n"
				+ "    \"md5\": \"3445076ad93c93933bff405a691c0b34\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918196\",\n"
				+ "    \"md5\": \"d47f75b5700a306baf8faed1fbe15fb1\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918197\",\n"
				+ "    \"md5\": \"da9e951a47b5846bf8205ebb6ce238aa\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918198\",\n"
				+ "    \"md5\": \"2410ab0db2d058efb4c1226b808a7621\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918199\",\n"
				+ "    \"md5\": \"9fa659e344cb16821e046c65ce96ef4f\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918200\",\n"
				+ "    \"md5\": \"481b50f61ee418acbea694d0f317c70d\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918201\",\n"
				+ "    \"md5\": \"961a4e1b349fc70b64684ae5538f4dc3\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918202\",\n"
				+ "    \"md5\": \"ae01dcd603cbd7f67d33536ee68848d3\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918203\",\n"
				+ "    \"md5\": \"7b0cdb07d2a04f8c3f6543bb4599e9ef\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918204\",\n"
				+ "    \"md5\": \"c83870e2c626f3e2cebf935404c6d8a8\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918205\",\n"
				+ "    \"md5\": \"cf3855e769075ba44276384168b6f2c7\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918206\",\n"
				+ "    \"md5\": \"ff870e0c81eb70da4ba3ef7856dbba17\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918207\",\n"
				+ "    \"md5\": \"8a5d67439eda7f826c9087914f1a9eba\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918208\",\n"
				+ "    \"md5\": \"9ac8c2515f93fe295617514029d4ff04\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918209\",\n"
				+ "    \"md5\": \"81fe0f2cf0131d2f87aeac18e481a231\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918210\",\n"
				+ "    \"md5\": \"9e650dafe5e8c2eafb4dee98a61d2c74\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918211\",\n"
				+ "    \"md5\": \"884a5ae8487120cae285c76ff2bce270\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918212\",\n"
				+ "    \"md5\": \"33bcf6e95b0315a1156e8bb9103d6da1\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918213\",\n"
				+ "    \"md5\": \"e66f5bd18c55a9b2bf5629de2069eaac\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918214\",\n"
				+ "    \"md5\": \"0a94db3f5d059b4f1eab0d798cdc02a6\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918215\",\n"
				+ "    \"md5\": \"d779250bdd5eea5a14b185763c36bf72\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918216\",\n"
				+ "    \"md5\": \"6c17c2e0244369ac8883503d03e95788\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918217\",\n"
				+ "    \"md5\": \"cd4df72e2afe85f3469f79f12f3259fe\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918218\",\n"
				+ "    \"md5\": \"1aa00e9acc0c89026f1002b86b0f677f\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918219\",\n"
				+ "    \"md5\": \"b89be1658197f1b34e6e979ca8152408\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918220\",\n"
				+ "    \"md5\": \"2b60ae3b401cb482d04e850a6d96c74f\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918221\",\n"
				+ "    \"md5\": \"2a39f2247af9e1876a845eb4a9952a57\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918222\",\n"
				+ "    \"md5\": \"46155f2a6b4b0c2c27a6226dc632bade\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918223\",\n"
				+ "    \"md5\": \"2e5ef702f1cfb3f058be39603009fa87\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918224\",\n"
				+ "    \"md5\": \"9f9e8986d1ee943b91d9b21c95135ad8\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918225\",\n"
				+ "    \"md5\": \"425ed349868de684196fb5e764ca3627\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918226\",\n"
				+ "    \"md5\": \"1a167b55c0d238071136f44b93677324\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918227\",\n"
				+ "    \"md5\": \"f866878838d81a55f5099e84233ca488\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918228\",\n"
				+ "    \"md5\": \"37284df32d88b7cccd1238ce04faead6\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918229\",\n"
				+ "    \"md5\": \"0afec5640623cbb5a36c7d4217a4c94e\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918230\",\n"
				+ "    \"md5\": \"0804d73579fe7ff14ad4df940a3f984d\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918231\",\n"
				+ "    \"md5\": \"f3c54cc221600621f612699d20f191cb\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918232\",\n"
				+ "    \"md5\": \"e6e44e8b2233a779f6cbbf794cff028b\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918233\",\n"
				+ "    \"md5\": \"faeadf779c6a6d709f8656f72f298ce3\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918234\",\n"
				+ "    \"md5\": \"660aa966a43ac9fc1a6a6e7f6db94269\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918235\",\n"
				+ "    \"md5\": \"46be005893042ed849967565ab343abb\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918236\",\n"
				+ "    \"md5\": \"e062ec97926679c00026206e6542a09c\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918237\",\n"
				+ "    \"md5\": \"6b13e7b209e98efeb11c3b05dd5661b7\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918238\",\n"
				+ "    \"md5\": \"cc143d1d88869dd75a7a6d2bbf261a8d\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918239\",\n"
				+ "    \"md5\": \"7f5e66698cf409e1f423e1850266ec82\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918240\",\n"
				+ "    \"md5\": \"10a7436c2cd9515e05d6848e63f2bbe9\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918241\",\n"
				+ "    \"md5\": \"0311209e978e04a6bad31303822ca4b4\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918242\",\n"
				+ "    \"md5\": \"4a2f15c937c37d0ba00d9850fcd17e2c\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918243\",\n"
				+ "    \"md5\": \"03aed9a3f132a5b96e0a0bc554116415\",\n" + "    \"totalCopies\": 10,\n"
				+ "    \"availableCopies\": 10\n" + "  },\n" + "  {\n" + "    \"id\": \"918244\",\n"
				+ "    \"md5\": \"5027147d35fda0be7b9b961836778e8e\"\n" + "  }\n" + "]";
		ObjectMapper mapper = new ObjectMapper();
		Book[] books;
		try {
			books = mapper.readValue(bookList, Book[].class);
			this.bookKeeper.saveAll(Arrays.asList(books));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}

}
