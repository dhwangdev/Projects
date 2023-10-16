DROP DATABASE IF EXISTS healing_db;

CREATE DATABASE healing_db CHARACTER SET=utf8mb4;

USE healing_db;

#################################### User 정보 ####################################
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    `user_id`         VARCHAR(40)      NOT NULL    						  COMMENT '유저 아이디', 
    `user_password`   VARCHAR(40)      NOT NULL    						  COMMENT '유저 비밀번호', 
    `user_email`      VARCHAR(40)      NOT NULL    						  COMMENT '유저 이메일', 
    `user_nickname`   VARCHAR(20)      NOT NULL    						  COMMENT '유저 닉네임', 
    `user_image`      VARCHAR(100)     NULL        						  COMMENT '프로필이미지경로', 
    `user_join_date`  DATE             NOT NULL    DEFAULT (current_date) COMMENT '가입날짜', 
     PRIMARY KEY (user_id)
);
INSERT INTO user VALUES('ssafy', '1234', 'ssafy.naver.com', 'ssafy', '', (current_date));
SELECT * FROM user;
#################################### 게시글 정보 ####################################
DROP TABLE IF EXISTS article;
CREATE TABLE article
(
    `article_id`               INT            NOT NULL    AUTO_INCREMENT COMMENT '게시글번호', 
    `article_title`            VARCHAR(100)   NOT NULL    				 COMMENT '게시글 제목', 
    `article_writer`           VARCHAR(20)    NOT NULL   				 COMMENT '게시글 작성자(닉네임)', 
    `article_content`          VARCHAR(10000) NOT NULL  				 COMMENT '게시글 내용', 
    `article_category`         VARCHAR(20)    NOT NULL   				 COMMENT '게시글 카테고리', 
    `article_view_count`       INT    		  NOT NULL    DEFAULT 0 	 COMMENT '조회수', 
    `article_recommend_count`  INT            NOT NULL    DEFAULT 0 	 COMMENT '추천수', 
    `article_write_date`       DATETIME       NOT NULL    DEFAULT now()  COMMENT '작성날짜(수정날짜)', 
    `article_comment_count`    INT            NOT NULL    DEFAULT 0		 COMMENT '댓글 수', 
     PRIMARY KEY (article_id)
);

SELECT * FROM article;

INSERT INTO article(`article_title`, `article_writer`, `article_content`, `article_category`, `article_view_count`, `article_recommend_count`, `article_write_date`, `article_comment_count`) 
VALUES
('역량테스트 A+ 따신분들 질문있습니다.' , '이진혁', '이번에 역량테스트 시험보는데 저번 시험에는 dp나왔나요? dp너무 어려운데..', 'chat' , 110 , 3, '2022-11-20 16:24:22',0),
('어렵다어렵다..' , '권지훈', '아닌가 안어렵나? 아 뭐야 쉽네', 'chat',24 , 1, '2022-11-20 16:44:37', 0),
('피곤하거나 컨디션이 좋지 않다면 차라리 쉬는것이 좋습니다.' , 'ssafy', '개발자들은 피곤할 때 평소보다 2~5배 더 많은 버그와 실수를 만들어 낸다고 합니다. 피곤하다면 기분전환 겸 산책을 하는게 어떨까요?', 'info',5262,635, '2022-11-20 19:26:22', 0);






#################################### 댓글 정보 ####################################
DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
    `comment_id`               INT              NOT NULL    AUTO_INCREMENT COMMENT '댓글 id', 
    `comment_writer`           VARCHAR(20)      NOT NULL    			   COMMENT '댓글 작성자', 
    `comment_content`          VARCHAR(1000)    NOT NULL    			   COMMENT '댓글 내용', 
    `comment_article_id`       INT              NOT NULL    			   COMMENT '게시글 id(댓글이 달린 게시글id)', 
    `comment_category`         VARCHAR(20)      NOT NULL    			   COMMENT '큰 카테코리(movie, food, sport ...)', 
    `comment_recommend_count`  INT              NOT NULL    DEFAULT 0 	   COMMENT '댓글 추천수', 
    `comment_write_date`       DATETIME         NOT NULL    DEFAULT now()  COMMENT '작성날짜(수정날짜)', 
    `comment_delete`		   TINYINT	        NOT NULL 	DEFAULT 0	   COMMENT '삭제여부 0:삭제안됨, 1:삭제됨',
     PRIMARY KEY (comment_id)
);
SELECT * FROM comment;
CREATE TABLE recomment
(
    `recomment_id`               INT              NOT NULL    AUTO_INCREMENT COMMENT '대댓글 id', 
    `recomment_writer`           VARCHAR(20)      NOT NULL    			   COMMENT '대댓글 작성자', 
    `recomment_content`          VARCHAR(1000)    NOT NULL    			   COMMENT '대댓글 내용', 
    `recomment_comment_id`       INT              NOT NULL    			   COMMENT '댓글 id',
    `recomment_recommend_count`  INT              NOT NULL    DEFAULT 0 	   COMMENT '대댓글 추천수', 
    `recomment_write_date`       DATETIME         NOT NULL    DEFAULT now()  COMMENT '작성날짜(수정날짜)', 
    `recomment_delete`		   TINYINT	        NOT NULL 	DEFAULT 0	   COMMENT '삭제여부 0:삭제안됨, 1:삭제됨',
     PRIMARY KEY (recomment_id)
);
INSERT INTO recomment VALUES(0, 'sangtan', '222222', 1, 0, now(), 0);
INSERT INTO recomment VALUES(0, 'wlswl2435', '333333', 1, 0, now(), 0);
#################################### Movie 정보 ####################################
DROP TABLE IF EXISTS movie;
CREATE TABLE movie
(
    `movie_id`             INT             NOT NULL    			 COMMENT '영화 id', 
    `movie_title`          VARCHAR(50)     NOT NULL    			 COMMENT '제목', 
    `movie_genre`          VARCHAR(100)    NOT NULL    			 COMMENT '영화 장르(문자 배열)', 
    `movie_overview`       VARCHAR(10000)    NOT NULL    			 COMMENT '영화 개요', 
    `movie_recommend_count`INT             NOT NULL    DEFAULT 0 COMMENT '추천 수', 
    `movie_backdrop_path`  VARCHAR(100)    NULL    			 COMMENT '영화 배경 주소', 
    `movie_poster_path`    VARCHAR(100)    NOT NULL    			 COMMENT '영화 포스터 경로', 
    `movie_popularity`     FLOAT           NOT NULL    			 COMMENT '인기도', 
    `movie_release_date`   DATE            NOT NULL    			 COMMENT '개봉일', 
	`movie_comment_count`  INT             NOT NULL    DEFAULT 0 COMMENT '댓글 수', 
    `movie_key`	   VARCHAR(100)    NOT NULL    			 COMMENT '영화 key값', 
     PRIMARY KEY (movie_id)
);

#################################### recipe 정보 ####################################
DROP TABLE IF EXISTS recipe;
CREATE TABLE recipe
(
    `recipe_id`             INT             NOT NULL    AUTO_INCREMENT    COMMENT '레시피 index', 
    `recipe_menu`           VARCHAR(500)     NOT NULL    				  COMMENT '메뉴명', 
    `recipe_eng`            VARCHAR(20)     NOT NULL    				  COMMENT '열량', 
    `recipe_car`            VARCHAR(20)     NOT NULL    				  COMMENT '탄수화물', 
    `recipe_pro`            VARCHAR(20)     NOT NULL    				  COMMENT '단백질', 
    `recipe_fat`            VARCHAR(20)     NOT NULL    				  COMMENT '지방', 
    `recipe_na`             VARCHAR(20)     NOT NULL    				  COMMENT '나트륨', 
    `recipe_small_img`      VARCHAR(100)    NOT NULL    				  COMMENT '이미지경로(소)', 
    `recipe_big_img`        VARCHAR(100)    NOT NULL    				  COMMENT '이미지경로(대)', 
    `recipe_recommend_count`INT             NOT NULL    DEFAULT 0         COMMENT '추천 수', 
    `recipe_parts`          VARCHAR(500)    NOT NULL    				  COMMENT '재료정보', 
    `recipe_comment_count`  INT             NOT NULL    DEFAULT 0         COMMENT '댓글 수', 
    `recipe_manual01`       VARCHAR(200)    NULL        				  COMMENT '만드는법_01', 
    `recipe_manual02`       VARCHAR(200)    NULL        				  COMMENT '만드는법_02', 
    `recipe_manual03`       VARCHAR(200)    NULL        				  COMMENT '만드는법_03', 
    `recipe_manual04`       VARCHAR(200)    NULL        				  COMMENT '만드는법_04', 
    `recipe_manual05`       VARCHAR(200)    NULL        				  COMMENT '만드는법_05', 
    `recipe_manual06`       VARCHAR(200)    NULL        				  COMMENT '만드는법_06', 
    `recipe_manual07`       VARCHAR(200)    NULL        				  COMMENT '만드는법_07', 
    `recipe_manual08`       VARCHAR(200)    NULL        				  COMMENT '만드는법_08', 
    `recipe_manual09`       VARCHAR(200)    NULL        				  COMMENT '만드는법_09', 
    `recipe_manual10`       VARCHAR(200)    NULL        				  COMMENT '만드는법_10', 
    `recipe_manual11`       VARCHAR(200)    NULL        				  COMMENT '만드는법_11', 
    `recipe_manual12`       VARCHAR(200)    NULL        				  COMMENT '만드는법_12', 
    `recipe_manual13`       VARCHAR(200)    NULL        				  COMMENT '만드는법_13', 
    `recipe_manual14`       VARCHAR(200)    NULL        				  COMMENT '만드는법_14', 
    `recipe_manual15`       VARCHAR(200)    NULL        				  COMMENT '만드는법_15', 
    `recipe_manual16`       VARCHAR(200)    NULL        				  COMMENT '만드는법_16', 
    `recipe_manual17`       VARCHAR(200)    NULL        				  COMMENT '만드는법_17', 
    `recipe_manual18`       VARCHAR(200)    NULL        				  COMMENT '만드는법_18', 
    `recipe_manual19`       VARCHAR(200)    NULL        				  COMMENT '만드는법_19', 
    `recipe_manual20`       VARCHAR(200)    NULL        				  COMMENT '만드는법_20', 
    `recipe_manual_img01`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_01', 
    `recipe_manual_img02`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_02', 
    `recipe_manual_img03`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_03', 
    `recipe_manual_img04`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_04', 
    `recipe_manual_img05`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_05', 
    `recipe_manual_img06`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_06', 
    `recipe_manual_img07`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_07', 
    `recipe_manual_img08`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_08', 
    `recipe_manual_img09`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_09', 
    `recipe_manual_img10`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_10', 
    `recipe_manual_img11`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_11', 
    `recipe_manual_img12`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_12', 
    `recipe_manual_img13`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_13', 
    `recipe_manual_img14`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_14', 
    `recipe_manual_img15`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_15', 
    `recipe_manual_img16`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_16', 
    `recipe_manual_img17`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_17', 
    `recipe_manual_img18`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_18', 
    `recipe_manual_img19`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_19', 
    `recipe_manual_img20`   VARCHAR(100)    NULL        				  COMMENT '만드는법_이미지_20', 
     PRIMARY KEY (recipe_id)
);
#################################### book 정보 ####################################
DROP TABLE IF EXISTS book;
CREATE TABLE book
(
	`book_id`             INT             NOT NULL   			AUTO_INCREMENT    COMMENT '레시피 index',
    `book_isbn`           VARCHAR(20)     NOT NULL    			COMMENT '책 isbn 13자리(숫자)', 
    `book_title`          VARCHAR(1000)    NOT NULL    			COMMENT '책 이름', 
    `book_author`         VARCHAR(1000)     NOT NULL    			COMMENT '저자', 
    `book_pubdate`        DATE            NOT NULL    			COMMENT '출간일', 
    `book_description`    VARCHAR(500)    NOT NULL    			COMMENT '요약', 
    `book_price`          INT             NOT NULL    			COMMENT '정가 (pricestandard 사용)', 
    `book_cover`          VARCHAR(100)    NOT NULL    			COMMENT '표지', 
    `book_publisher`      VARCHAR(45)     NOT NULL    			COMMENT '출판사',
    `book_category`		  VARCHAR(45)     NOT NULL  			COMMENT '카테고리분류',
    `book_category_name`  VARCHAR(100)    NOT NULL    			COMMENT '카테고리이름', 
    `book_review_rank`    INT             NOT NULL    			COMMENT '회원 리뷰 평점(별점 평균) : 0~10점(별0.5개당 1점)', 
    `book_best_duration`  VARCHAR(45)     NULL        			COMMENT '(베스트셀러인 경우만 노출) 베스트셀러 순위 관련 추가 정보', 
    `book_best_rank`      INT             NULL        DEFAULT 0 COMMENT '(베스트셀러인 경우만 노출) 베스트셀러 순위 정보', 
    `book_recommend_count`INT             NOT NULL    DEFAULT 0 COMMENT '추천 수', 
    `book_comment_count`  INT             NOT NULL    DEFAULT 0 COMMENT '댓글 수', 
     PRIMARY KEY (book_id)
);
#################################### sport 정보 ####################################

DROP TABLE IF EXISTS sport;
CREATE TABLE sport
(
    `sport_id`               INT             NOT NULL    AUTO_INCREMENT COMMENT '스포츠 영상 id', 
    `sport_title`            VARCHAR(100)    NOT NULL    				COMMENT '스포츠 영상 제목', 
    `sport_key`              VARCHAR(100)    NOT NULL  	 				COMMENT '스포츠 영상 키값', 
    `sport_recommend_count`  INT             NOT NULL    DEFAULT 0		COMMENT '스포츠 영상 추천 수', 
    `sport_comment_count`    INT             NOT NULL    DEFAULT 0		COMMENT '스포츠 영상 댓글 수', 
    `sport_category`         VARCHAR(100)    NOT NULL    				COMMENT '스포츠 영상 카테고리', 
    `sport_view_count`       INT             NOT NULL    DEFAULT 0		COMMENT '스포츠 영상 조회 수', 
     PRIMARY KEY (sport_id)
);

INSERT INTO sport(`sport_title`, `sport_key`, `sport_recommend_count`, `sport_category`, `sport_view_count`) Values 
("전신 다이어트 최고의 운동[칼소폭 찐 핵핵매운맛]", "gMaB-fG4u4g", 24, "health", 192),
("전신 다이어트 최고의 운동 [칼소폭 핵매운맛]", "CTojmKLkWTo", 10, "health", 124),
("2주만에 복근 만드는 운동 2 MIN ABS WORKOUT", "PoYzxj8Iy5M", 46, "health", 205),
("하루 15분! 전신 칼로리 불태우는 다이어트 운동", "swRNeYw1JkY", 68, "health", 1881),
("쏟아지는 미아핑! 사기챔으로 천상계 학살하는 장인들 | 롤읽남 롤 매드무비", "W6In7FDl1Js", 349, "esports", 19225),
("전설을 만들어 갑니다 LCK | T1 vs. DRX 게임5 하이라이트 | Finals | 11.06 | 2022 월드 챔피언십", "SKWo_YWVjJ8", 3364, "esports", 74882),
("파카 환상의 닐라 쇼 | 롤 스트림 하이라이트", "yJVF2h9b9t4", 29, "esports", 192),
("트로피 세레머니 Presented by Mercedes-Benz l 2022 월드 챔피언십", "m54j0Oax6wc", 294, "esports", 152),
("T1 월즈 매드무비 | 2022 월드 챔피언십", "rmzXi2DRnLA", 114, "esports",  667),
("알의 안식처 | GEN vs. DRX 게임2 하이라이트 | Semi Finals | 10.31 | 2022 월드 챔피언십", "_iDJqpOkBKQ", 644, "esports", 2958),
("프렐요드의 최상품이네!🕶️ | DRX vs. EDG 게임4 하이라이트 | Quarter Finals | 10.24 | 2022 월드 챔피언십", "vu8GyMhQCDU", 235, "esports", 352),
("펄-럭 | GEN vs. DK 게임5 하이라이트 | Quarter Finals | 10.23 | 2022 월드 챔피언십", "5FTkyfAHVtg", 345, "esports", 886),
("와! 역시 구마유시! 오! 완전 협곡을 뒤집어 놓으셨다. | T1 vs. RNG 게임2 하이라이트 | Quarter Finals | 10.22 | 2022 월드 챔피언십", "3PQZT8ahB4o", 948, "esports", 5838),
("생일버프 | DRX vs. EDG 게임3 하이라이트 | Quarter Finals | 10.24 | 2022 월드 챔피언십", "6mI7BmjA3Ws", 36, "esports", 152),
("GEN Doran, DK Kellin 인터뷰 | Quarter Finals | 2022 월드 챔피언십", "EDtJIb4cRaE", 193, "esports", 787),
("각'도란' 이런 것이다 | 월즈 매드무비 Group Stage Day 8 | 2022 월드 챔피언십", "SxjV25RVXmw", 596, "esports", 1965),
("DRX vs. RGE 매치 하이라이트 | Groups Day 7 | 10.16 | 2022 월드 챔피언십", "LnizGS1yogA", 0, "esports", 1),
("파라과이 전 하이라이트 | 2022 축구 국가대표 평가전 대한민국 vs 파라과이 하이라이트 | 디지털 독점 생중계 | 쿠팡플레이 | 쿠팡", "ZqOjOrVgbnc", 34, "sports", 53),
("대한민국 VS 이집트 : 하나은행 초청 축구국가대표팀 친선경기 하이라이트 - 2022.06.14", "1GiUpCkKKvM", 63, "sports", 325),
("[2022-2023시즌 V리그 1라운드. GS칼텍스 vs KGC인삼공사]11월 15일 여자프로배구 경기하이라이트.", "OvEp1w1wAyE", 1, "sports", 235),
("대한민국 VS 코스타리카 : 하나은행 초청 축구국가대표팀 친선경기 하이라이트 - 2022.09.23", "xNkMbGrUdqU", 3, "sports", 35),
("2020 도쿄올림픽 여자 배구 A조 4차전 대한민국 vs 일본 [습츠_도쿄올림픽]", "M0C-jWu7n3s", 94, "sports", 351),
("[22/23 UCL] 토트넘 vs 프랑크푸르트 손흥민 활약상", "lIR5HyC-C0M", 346, "sports", 2896),
("2020 도쿄올림픽 여자 배구 A조 4차전 대한민국 vs 일본 [습츠_도쿄올림픽]", "M0C-jWu7n3s", 32, "sports", 192),
("헬스할 때 '몸통 두께'부터 키워야 하는 이유?(등과 흉곽을 두텁게 만드는 운동루틴)", "9yqYgn2tCL0", 111, "health", 784),
("체중별 다이어트 방법 싹 정리해서 알려드립니다!(비만-과체중-통통)", "DQrsQiqphkg", 222, "health", 586),
("헬스를 막 시작하신분들이나 시작하려고 하시는 분들은 일단 이 5가지 운동만 해보세요. 헬스장 운동기구 탑5 사용법", "CnLZUXQofiI", 333, "health", 938),
("일반인의 '근육량'을 가장 빠르게 늘려주는 '운동순서'는?", "TY0HF4SMzhU", 244, "health", 565),
("페이커 국제 대회 BEST 10 명장면", "aDYD3267-5M", 2634, "esports", 38582),
("일주일에 몇번 운동해야 '근육'이 잘 늘어날까?", "qeh5QDoVzx4", 237, "health", 675),
("익스트림 스포츠 역대급 사람들 [감동주의] │ The best video of awesome people", "UZlskV4Zhtw", 444, "extreme", 987),
("푸쉬업 '제발' 이렇게만 하세요! 가슴자극 200%높이는 방법!?(팔굽혀펴기 정자세,대흉근 운동)", "8txh_smTqPA", 233, "health", 538),
("매드라이프(Madlife) 전성기 시절 블리츠크랭크 픽 함성소리", "5kx6saIT5jo", 2234, "esports", 5839),
("익스트림 스포츠, 몸의 한계를 뛰어넘다! [다큐S프라임] / YTN 사이언스", "UlJ96I_-OIA", 274, "extreme", 385),
("[Extreme Sports] 익스트림 스포츠 세계로 초대합니다. | 스포츠 종류, extreme sports video", "zhILfMZyAKU", 363, "extreme", 694),
("매드라이프가 '매멘' 했던 순간들 TOP10", "orTVT9XESxQ", 2363, "esports", 103895),
("헬스초보자 라면 이 순서대로 운동해야 합니다! (헬린이 근육량 늘리는 운동루틴)", "4GOAjCsz9UA", 236, "health", 834),
("21/22시즌 손흥민 선수 득점 경기 하이라이트 모음.ZIP", "-0OvfnYe5Go", 2437, "sports", 5968),
("아시아 최초 프리미어리그 득점왕 “손흥민”｜21-22 PL 손흥민 모든 골 모음", "WOww2jMyUjU", 2436, "sports", 23844),
("'매라병의 근원' 1세대 역체폿 매드라이프 매드무비 / best of madlife montage", "fsNKkItxFX8", 2434, "esports", 58365),
("익스트림 스포츠의 끝판왕들", "F-DoidPbz1Y", 2478, "extreme", 83751),
("반박불가 현시점 세리에 A 센터백 원탑, 김민재｜김민재 22/23 시즌 활약상", "LTwPc6s1ibc", 254, "sports", 998),
("2020 도쿄올림픽 여자 핸드볼 A조 3차전 대한민국 vs 일본 [습츠_도쿄올림픽]", "mLBlCILKeT8", 224, "sports", 583),
("유럽 관중들을 감동시켰던 전설의 페이커 야스오 1대4 경기", "M_vg12_QXrg", 6724, "esports", 54982),
("NBA급 페이크란? [NBA하이라이트]", "02LIMR7bfko", 624, "sports", 4895),
("NBA 선수들의 미친 드리블", "Dy36igsWb_w", 244, "sports", 332),
("Extreme Parkour and Freerunning", "oIJ5m1_6E24", 2435, "extreme", 246),
("마지막에 경기를 끝내는 NBA 엔딩 버저비터 모음", "6JIRjMiv2QA", 2634, "sports", 3598),
("산타 손흥민이 준비한 다섯 가지 선물 (손흥민 윈터 원더골 모음)", "Sp1Gxe5BYQ8", 23344, "sports", 92598),
("[랭킹] 보고도 믿기 힘든 목숨 건 도전 9", "AeNd1G9OYkA", 2434, "extreme", 40694),
("Top 10 Extreme Sports", "WDKc6z4LRgQ", 2464, "extreme", 4874),
("'70m 질주' 손흥민 번리전 현지해설 '그는 월드클래스입니다'", "6d4d3yRxEok", 24322, "sports", 59459),
("[하이라이트] 숙명의 한일전, 기분 좋은 첫 승! 여자 핸드볼 조별 예선 A조 대한민국 : 일본 하이라이트", "jXQyp5qr4M0", 243, "sports", 482),
("지구상에서 자전거 제일 잘타는 '신'들의 대회! 자전거 천상계 대회", "XQ5VKXGvCdk", 2446, "extreme", 43987),
("아찔한 익스트림 스포츠 베스트 #1 Creepy Extreme Sports Best", "_9CTi8hEBZU", 2624, "extreme", 58476),
("왕초보를 위한 요가 🧎‍♀️ㅣ15 Minute Yoga for Beginnersㅣ15분 요가 루틴", "IEjNstAjAkk", 939, "health", 32873),
("[하이라이트] 최강야구 회식이다(๑˃́ꇴ˂̀๑)!! 믿음의 야구 정의윤의 첫 홈런⚾ (vs 인하대 2차전)", "YbWA8ZZvzFM", 11, "sports", 126),
("2008 베이징 올림픽 수영 남자 400m 자유형ㅣ박태환", "YROz_7u55VI", 124, "sports", 3346),
("2008 베이징 올림픽 수영 200M 자유형, 200M 혼영, 100M 접영ㅣ마이클 펠프스", "tV_LL6YxH_c", 54, "sports", 235),
("주말의 홈트｜한수진의 요가 한 수, ‘남녀노소 누구나 할 수있는 스트레칭’", "TEQ4FapAZe4", 1235, "health", 34677),
("[야구 하이라이트] ‘역대급 끝내기??’ 첫판부터 진땀 흘린 한국 야구", "hlyyX-x8vqw", 734, "sports", 6568),
("2008 베이징 올림픽 역도 여자 +75kgㅣ장미란", "vl7FyE-SHWU", 2, "sports", 45),
("NO 층간소음 올인원 운동 - 40분 유산소운동 홈트 - 관절에 무리없이 체지방 태우기", "myNjmnvI6x0", 5126, "health", 78976),
("2022 ISU 쇼트트랙 월드컵 2차 대회 남자 계주 5000m 결승", "qK_ddnKvFRw", 634, "sports", 7457),
("여자 컬링 준결승 한일전 주요장면..1엔드부터 11엔드까지 (하이라이트) / SBS / 2018 평창올림픽", "9LkGvRNS3WE", 55, "sports", 527),
("맨몸운동으로 대포알 어깨 만드는 방법 | 20분 루틴", "hwD9GVcEMEY", 634, "health", 2353),
("[하이라이트] 버릴 장면이 1도 없는 컬링 한일전! 이거 보고 체했던 속이 뻥 뚫렸습니다....", "1NMlByABOf0", 516, "sports", 967),
("전신/하체비만/상체비만/골반교정/승모근/종아리알 스트레칭 이거 하나로 끝!", "nOGT4lXlSHw", 532, "health", 4868),
("대한민국 쇼트트랙_역전 베스트 10", "dxr6ymPUEnE", 55, "sports", 237),
("'이게 MLB야 KBO야?' 크보 미친 호수비 모음", "LQaVF6KYk0o", 689, "sports", 3731),
("[하이라이트] 이것이 찰떡호흡! 곽윤기는 멘탈갑 증명했다!!!", "Xw28L5oJykc", 63, "sports", 485),
("탁구 랭킹 1위 마롱 VS 탁구 랭킹 2위 쉬신", "XNruyYa6os0", 12, "sports", 125),
("맨몸으로 층간 소음 없이 빠르게 칼로리 태우는 전신 운동 루틴🔥 [근력 유산소: 웨이홈트]", "_AH7u-q7V3M", 535, "health", 2364),
("Top 10 탁구 진기 명기", "4qh9ht7JzZA", 4, "sports", 234),
("매일하기 좋은 15분 데일리 스트레칭 | 기초 요가 스트레칭, 전신 스트레칭", "tZEZNsuDkLY", 532, "health", 2345),
("2020 도쿄올림픽 양궁 혼성 단체전 16강, 8강, 준결승, 결승 하이라이트ㅣ김제덕 · 안산 [습츠_도쿄올림픽]", "rMJ7ZgK4arw", 67, "sports", 237),
("전신을 골고루 다 쓰는 55분 요가 | 빈야사 요가, 전신요가 스트레칭", "z4FEpAIEdmk", 965, "health", 346),
("[결승전 하이라이트] 필요했던 딱 한 발이 과녁에 꽂혔다! 대단하다 한국 양궁!!", "6s43WDIAntw", 1521, "sports", 3743),
("[평창 2018] 넘어져도 1위 넘어져도 올림픽신기록! 최강 쇼트트랙 여자 계주팀", "tFIORav2YQw", 1153, "sports", 2346),
("으아! 땅땅땅 빵!", "83pjAmgKx_s", 75962, "esports", 852654);


        
        
        
