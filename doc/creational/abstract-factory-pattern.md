# 추상 팩토리 패턴
> 서로 관련있는 여러 객체를 만들어주는 인터페이스

- 구체적으로 어떤 클래스의 인스턴스(concrete product)를 사용하는지 감출 수 있다.
- "**팩토리를 사용하는 방법**"에 초첨을 둔다.
  > 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적이다.

## Java와 Spring에서 찾아보는 팩토리 메소드 패턴
### 자바 라이브러리
- javax.xml.xpath.XPathFactory#newInstance()
- javax.xml.transform.TransformerFactory#newInstance()
- javax.xml.parsers.DocumentBuilderFactory#newInstance()

### Spring
- FactoryBean과 그 구현체