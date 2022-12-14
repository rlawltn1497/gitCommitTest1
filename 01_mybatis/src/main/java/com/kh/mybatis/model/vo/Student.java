package com.kh.mybatis.model.vo;

/**
 * @Lombok 사용법

 *  Annotation	설명
	@NonNull	Null 값이 될 수 없다는 것을 명시합니다. NullPointerException에 대한 대비책이 될 수 있습니다.
	@Cleanup	자동으로 close() 메소드를 호출합니다.
	@Getter/@Setter	코드가 컴파일 될 때, Getter/Setter 메소드를 생성합니다.
	@ToString	toString() 메소드를 생성합니다. @ToString(exclude={"제외할 값"}) 처럼 원하지 않는 속성은 제외할 수 있습니다.
	@EqualsAndHashCode	해당 객체의 equals()와 hashCode() 메소드를 생성합니다.
	@NoArgsConstructor	파라미터를 받지 않는 생성자를 만들어 줍니다.
	@RequiredArgsConstructor	지정된 속성들에 대해서만 생성자를 만듭니다.
	@AllArgsConstructor	모든 속성에 대해서 생성자를 만들어 냅니다.
	@Data : @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor를 합쳐 둔 어노테이션입니다.
	@Value				불변 클래스를 생성할 때 사용합니다.
	@Builder			빌더 패턴을 사용할 수 있도록 코드를 생성합니다.
	@SneakyThrows		예외 발생 시 Throwable 타입으로 반환합니다.
	@Syncronized		메소드에서 동기화를 설정합니다.
	@Getter(lazy=true)	동기화를 이용해서 최초 한번만 getter를 호출합니다.
 */


//Lombok(롬복)은 Java 라이브러리로 반복되는 getter, setter, toString 등의 메서드 작성 코드를 줄여주는 코드 다이어트 라이브러리입니다.
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Student {
	private int no;
	private String name;
	private String tel;
	private String email;
	private String address;
	private java.sql.Date regDate; // 마이바티스와 대응하기 위해선 반드시 sql.Date를 호출
	
	
}
