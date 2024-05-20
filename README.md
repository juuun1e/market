# < Market >
- 중고거래 마켓
- 판매자는 더 이상 사용하지 않는 물건을 등록하고, 구매자는 등록한 물건의 리스트와 상세설명을 조회할 수 있도록 사이트를 만들어보자.

<br>
<br>

## ⎷ function
1. 게시글 목록 DB 설계
    - 테이블명 : Item
        - id : 게시글 번호 (DB 인덱스)
        - title (String) :  게시글 제목
        - content (String) : 게시글 내용
        - price(int) : 가격
        - username : 작성자

<br>

2. 구현 API
    - 판매 게시글을 작성하는 API
    - 판매 게시글을 전체 조회하는 API
    - 판매 게시글을 수정하는 API
    - 판매 게시글을 삭제하는 API
