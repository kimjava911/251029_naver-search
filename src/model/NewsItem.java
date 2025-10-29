package model;

/*
{
    "title":"칠곡군, 국수 한 그릇에 담은 따뜻한 이웃사랑",
    "originallink":"https:\/\/www.asiatoday.co.kr\/view.php?key=20251029010012267",
    "link":"https:\/\/www.asiatoday.co.kr\/view.php?key=20251029010012267",
    "description":"이번 행사는 지역 어르신과 주민 40여 명이 참여한 가운데, 회원들이 정성껏 준비한 따뜻한 <b>칼국수<\/b>를 함께 나누며 서로의 안부를 전하고 정을 나누는 시간으로 진행됐다. 행사에 참석한 한 주민은 &quot;요즘같이 쌀쌀한... ",
    "pubDate":"Wed, 29 Oct 2025 14:38:00 +0900"
}
 */
public record NewsItem(String title,
                       String originallink,
                       String link,
                       String description,
                       String pubDate) { }
