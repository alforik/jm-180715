package kr.ac.jm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.ac.jm.domain.Member;
import kr.ac.jm.dto.MemberRepository;

@SpringBootApplication
public class Jm180715Application {

	public static void main(String[] args) {
		SpringApplication.run(Jm180715Application.class, args);
	}
	
	@Autowired
	MemberRepository memberRepository;
	
	//@Override
	public void run(String... args) throws Exception {

		memberRepository.save(new Member("a", 10));
		memberRepository.save(new Member("b", 15));
		memberRepository.save(new Member("c", 10));
		memberRepository.save(new Member("a", 5));
		
		Iterable<Member> list1 = memberRepository.findAll();
		
		System.out.println("findAll() Method.");
		for( Member m : list1){
			System.out.println(m.toString());
		}
		
		System.out.println("findByNameAndAgeLessThan() Method.");
		List<Member> list2 = memberRepository.findByNameAndAgeLessThan("a", 10);
		for( Member m : list2){
			System.out.println(m.toString());
		}
		
		System.out.println("findByNameAndAgeLessThanSQL() Method.");
		List<Member> list3 = memberRepository.findByNameAndAgeLessThanSQL("a", 10);
		for( Member m : list3){
			System.out.println(m.toString());
		}
		
		System.out.println("findByNameAndAgeLessThanSQL() Method.");
		List<Member> list4 = memberRepository.findByNameAndAgeLessThanOrderByAgeDesc("a", 15);
		for( Member m : list4){
			System.out.println(m.toString());
		}

		memberRepository.deleteAll();
	}
	
}
