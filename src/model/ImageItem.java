package model;

/*
{
    "title":"쉽게 닭볶음탕 맛있게 만드는법 닭볶음탕 황금레시피 닭도리탕",
    "link":"https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2023\/10\/20\/e95e3f78581f59ea96ec151e117cd2771.jpg",
    "thumbnail":"https:\/\/search.pstatic.net\/sunny\/?type=b150&src=https:\/\/recipe1.ezmember.co.kr\/cache\/recipe\/2023\/10\/20\/e95e3f78581f59ea96ec151e117cd2771.jpg",
    "sizeheight":"525",
    "sizewidth":"800"
},
 */
public record ImageItem(String title,
                        String link,
                        String thumbnail,
                        String sizeheight,
                        String sizewidth) { }
