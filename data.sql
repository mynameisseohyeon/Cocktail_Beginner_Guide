--## database 생성
--CREATE DATABASE cocktail DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
--
--
--## dabatabase 선택
--use cocktail;
--
--
--## database 초기화
--CREATE TABLE cocktail (
--	idx INT(11) NOT NULL AUTO_INCREMENT,
--    name VARCHAR(100) NOT NULL,
--    abv VARCHAR(100) NOT NULL,
--    taste VARCHAR(100) NOT NULL,
--    ageGroup VARCHAR(100) NOT NULL,
--    snacks VARCHAR(100) NOT NULL,
--    priceRange VARCHAR(100) NOT NULL,
--    cocktailInfo VARCHAR(100) NOT NULL,
--    image VARCHAR(80) NOT NULL,
--    PRIMARY KEY(idx)
--);
--
--
/*INSERT INTO cocktail (name, abv, taste, age_group, snacks, price_range, cocktail_info, image)
VALUES
    ("마가리타", "40%", "신맛", "20-30대", "칩", "₩10,000-₩15,000", "마가리타는 소금으로 림을 장식한 클래식 데킬라 기반 칵테일입니다. 주로 데킬라, 라임 주스, 그리고 트리플 섹을 섞어 만들며, 상큼한 신맛과 함께 소금의 짭짤한 맛이 특징입니다. 이 칵테일은 보통 차갑게 제공되며, 종종 라임 웨지와 소금으로 림을 장식하여 제공됩니다.", "/img/cocktail1.jpg"),
    ("모히토", "15%", "민트향", "20-30대", "나초", "₩8,000-₩12,000", "모히토는 럼, 신선한 민트 잎, 라임 주스, 설탕, 그리고 소다수를 섞어 만드는 쿠바식 칵테일입니다. 상큼하고 시원한 맛이 특징이며, 여름에 인기가 많습니다. 전통적으로는 라임 웨지와 민트 잎으로 장식하여 제공됩니다.", "/img/cocktail2.jpg"),
    ("올드 패션드", "35%", "쓴맛", "30-40대", "견과류", "₩12,000-₩18,000", "올드 패션드는 위스키, 앙고스투라 비터스, 설탕 시럽, 그리고 물을 섞어 만드는 클래식 칵테일입니다. 쓴맛과 단맛이 조화롭게 어우러져 있으며, 종종 오렌지 껍질이나 체리로 장식하여 제공됩니다. 이 칵테일은 19세기 미국에서 유래되었으며, 오랜 역사를 가지고 있습니다.", "/img/cocktail3.jpg"),
    ("피나 콜라다", "13%", "단맛", "20-30대", "과일 플래터", "₩10,000-₩15,000", "피나 콜라다는 코코넛 크림과 파인애플 주스를 섞어 만드는 트로피컬 칵테일입니다. 달콤하고 부드러운 맛이 특징이며, 종종 파인애플 조각이나 체리로 장식하여 제공됩니다. 이 칵테일은 특히 열대 지방에서 인기가 많으며, 휴가나 파티에서 즐기기 좋습니다.", "/img/cocktail4.jpg"),
    ("마티니", "30%", "드라이", "30-40대", "올리브", "₩15,000-₩20,000", "마티니는 진과 드라이 베르무트를 섞어 만드는 클래식 칵테일입니다. 매우 심플하면서도 강렬한 맛이 특징이며, 올리브 한 개로 장식하여 제공됩니다. 마티니는 다양한 비율로 즐길 수 있으며, 비율에 따라 맛이 달라집니다. 예를 들어, 진의 비율이 높을수록 더 드라이한 맛이 납니다.", "/img/cocktail5.jpg");
*/