//package com.example.jpademo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class JpademoApplicationTests {
//
//	@Autowired
//	MovieRepository movieRepository;
//
//	@Test
//	void t1() {
//		System.out.println("---------------------------");
//	}
//
//	@Test
//	void insert() {
//		Movie m = new Movie(-1L, "테스트코드", "테스트코드", "/downoad/testcode/1");
//		movieRepository.save(m);
//		System.out.println("생성됨");
//	}
//
//	@Test
//	void selected() {
//		System.out.println(movieRepository.findAll());
//	}
//
//	@Test
//	void find() {
//		Movie m = movieRepository.findById(5L).get(); // 20이라는 id가 존재하지 않으면 null을 처리하기 위해 get함수를 사용 (optional함수를 까서 원래 타입을 반환
//		System.out.println(m);
//	}
//
//}
