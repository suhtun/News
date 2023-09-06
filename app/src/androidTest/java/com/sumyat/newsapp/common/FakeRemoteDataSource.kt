package com.sumyat.newsapp.common

import com.sumyat.newsapp.data.remote.dto.ArticleDto
import com.sumyat.newsapp.data.remote.dto.NewsDto
import com.sumyat.newsapp.data.remote.dto.SourceDto
import org.intellij.lang.annotations.Language

object FakeRemoteDataSource {

    val searchNewsFirstData = NewsDto(
        articles = listOf(
            ArticleDto(
                author = "https://www.facebook.com/bbcnews",
                title = "Praggnanandhaa: India chess prodigy's 'remarkable' impact on the sport",
                description = "R Praggnanandhaa lost the World Cup, but experts say he remains an inspirational figure in Indian chess.",
                url = "https://www.bbc.co.uk/news/world-asia-india-66613182",
                urlToImage = "https://ichef.bbci.co.uk/news/1024/branded_news/183CF/production/_130897299_gettyimages-1460268168-594x594.jpg",
                publishedAt = "2023-08-25T07:17:48Z",
                source = SourceDto(id = "bbc-news", "BBC News"),
                content = "Indian chess prodigy R Praggnanandhaa's World Cup run has ended without a trophy, but experts say that his stellar performances will have a monumental impact on the game in the country.\r\nThe Indian g… [+4246 chars]"
            ),
            ArticleDto(
                author = "https://www.facebook.com/bbcnews",
                title = "R Praggnanandhaa: India chess prodigy's 'remarkable' impact on the sport",
                description = "R Praggnanandhaa lost the World Cup, but experts say he remains an inspirational figure in Indian chess.",
                url = "https://www.bbc.co.uk/news/world-asia-india-66613182",
                urlToImage = "https://ichef.bbci.co.uk/news/1024/branded_news/183CF/production/_130897299_gettyimages-1460268168-594x594.jpg",
                publishedAt = "2023-08-25T07:17:48Z",
                source = SourceDto(id = "bbc-news", "BBC News"),
                content = "Indian chess prodigy R Praggnanandhaa's World Cup run has ended without a trophy, but experts say that his stellar performances will have a monumental impact on the game in the country.\r\nThe Indian g… [+4246 chars]"
            )
        ),
        status = "ok",
        totalResults = 34297
    )

    @Language("JSON")
    val searchNewsResponse = """
        {
           "status":"ok",
           "totalResults":34297,
           "articles":[
              {
                 "source":{
                    "id":"bbc-news",
                    "name":"BBC News"
                 },
                 "author":"https://www.facebook.com/bbcnews",
                 "title":"Praggnanandhaa: India chess prodigy's 'remarkable' impact on the sport",
                 "description":"R Praggnanandhaa lost the World Cup, but experts say he remains an inspirational figure in Indian chess.",
                 "url":"https://www.bbc.co.uk/news/world-asia-india-66613182",
                 "urlToImage":"https://ichef.bbci.co.uk/news/1024/branded_news/183CF/production/_130897299_gettyimages-1460268168-594x594.jpg",
                 "publishedAt":"2023-08-25T07:17:48Z",
                 "content":"Indian chess prodigy R Praggnanandhaa's World Cup run has ended without a trophy, but experts say that his stellar performances will have a monumental impact on the game in the country.\r\nThe Indian g… [+4246 chars]"
              },
              {
                 "source":{
                    "id":"bbc-news",
                    "name":"BBC News"
                 },
                 "author":"https://www.facebook.com/bbcnews",
                 "title":"R Praggnanandhaa: India chess prodigy's 'remarkable' impact on the sport",
                 "description":"R Praggnanandhaa lost the World Cup, but experts say he remains an inspirational figure in Indian chess.",
                 "url":"https://www.bbc.co.uk/news/world-asia-india-66613182",
                 "urlToImage":"https://ichef.bbci.co.uk/news/1024/branded_news/183CF/production/_130897299_gettyimages-1460268168-594x594.jpg",
                 "publishedAt":"2023-08-25T07:17:48Z",
                 "content":"Indian chess prodigy R Praggnanandhaa's World Cup run has ended without a trophy, but experts say that his stellar performances will have a monumental impact on the game in the country.\r\nThe Indian g… [+4246 chars]"
              }
           ]
        }
    """.trimIndent()

    val headlineFirstData = NewsDto(
        articles = listOf(
            ArticleDto(
                source = SourceDto(id = "reuters", "reuters"),
                title = "Jill Biden positive for COVID, President Biden tests negative -White House - Reuters",
                description = "U.S. first lady Jill Biden has tested positive for COVID-19 just days before President Joe Biden, who tested negative for the virus, is due to travel to a Group of 20 summit in India, the White House said on Monday.",
                url = "https://www.reuters.com/world/us/jill-biden-positive-covid-president-biden-tests-negative-white-house-2023-09-05/",
                urlToImage = "https://www.reuters.com/resizer/PL8V1Hjoja-vPa1I5YKeBAT_Nbw=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/OVNLRMEICNKQBMZBKIIGH6GUJI.jpg",
                publishedAt = "2023-09-05T12:29:00Z",
                content = "WASHINGTON, Sept 4 (Reuters) - U.S. first lady Jill Biden has tested positive for COVID-19 just days before President Joe Biden, who tested negative for the virus, is due to travel to a Group of 20 s… [+1574 chars]",
                author = "Reuters"
            )
        ),
        status = "ok",
        totalResults = 35
    )

    @Language("JSON")
    val headlinesResponse = """
        {
           "status":"ok",
           "totalResults":35,
           "articles":[
              {
                 "source":{
                    "id":"reuters",
                    "name":"reuters"
                 },
                 "author":"Reuters",
                 "title":"Jill Biden positive for COVID, President Biden tests negative -White House - Reuters",
                 "description":"U.S. first lady Jill Biden has tested positive for COVID-19 just days before President Joe Biden, who tested negative for the virus, is due to travel to a Group of 20 summit in India, the White House said on Monday.",
                 "url":"https://www.reuters.com/world/us/jill-biden-positive-covid-president-biden-tests-negative-white-house-2023-09-05/",
                 "urlToImage":"https://www.reuters.com/resizer/PL8V1Hjoja-vPa1I5YKeBAT_Nbw=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/OVNLRMEICNKQBMZBKIIGH6GUJI.jpg",
                 "publishedAt":"2023-09-05T12:29:00Z",
                 "content":"WASHINGTON, Sept 4 (Reuters) - U.S. first lady Jill Biden has tested positive for COVID-19 just days before President Joe Biden, who tested negative for the virus, is due to travel to a Group of 20 s… [+1574 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"CNBC"
                 },
                 "author":"Samantha Subin, Pia Singh",
                 "title":"S&P 500 futures slip to start the week: Live updates - CNBC",
                 "description":"S&P 500 futures were lower Tuesday morning as the market looks to maintain momentum in the holiday-shortened week.",
                 "url":"https://www.cnbc.com/2023/09/04/stock-market-today-live-updates.html",
                 "urlToImage":"https://image.cnbcfm.com/api/v1/image/107294516-1693495171428-gettyimages-1650708091-img_8114_widhmesr.jpeg?v=1693865312&w=1920&h=1080",
                 "publishedAt":"2023-09-05T11:53:00Z",
                 "content":"Stock futures hovered near the flatlineTuesday to start a holiday-shortened week.\r\nFutures tied to the Dow Jones Industrial Average was flat. S&amp;P 500 futures were lower by 0.18%, while Nasdaq 100… [+1845 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"BBC News"
                 },
                 "author":"https://www.facebook.com/bbcnews",
                 "title":"China's Great Wall damaged by workers looking for shortcut - BBC",
                 "description":"Part of the wall running through China's Shanxi province was dug open, causing severe damage.",
                 "url":"https://www.bbc.com/news/world-asia-china-66714547",
                 "urlToImage":"https://ichef.bbci.co.uk/news/1024/branded_news/6C1E/production/_130987672_mediaitem130987668.jpg",
                 "publishedAt":"2023-09-05T11:27:23Z",
                 "content":"A part of China's Great Wall has been severely damaged by construction workers in central Shanxi province, who used an excavator to dig through it. \r\nPolice say two people are suspected of trying to … [+2887 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"Florida Today"
                 },
                 "author":"Finch Walker",
                 "title":"COVID is on the rise in Florida: What to know about hospitalizations, testing - Florida Today",
                 "description":"COVID is up in Florida, and there are fewer resources since the federal emergency ended in May. Here's what to know.",
                 "url":"https://www.floridatoday.com/story/news/2023/09/04/covid-is-on-the-rise-in-florida-what-to-know-about-hospitalizations-testing/70700735007/",
                 "urlToImage":"https://www.floridatoday.com/gcdn/presto/2023/06/09/PMJS/38b7eda6-2dc6-4615-a2c0-4a2f8a190f25-MJS-COVID_Home_Test.jpg?crop=6797,3823,x363,y483&width=3200&height=1800&format=pjpg&auto=webp",
                 "publishedAt":"2023-09-05T11:00:16Z",
                 "content":"COVID cases have again been spreading in Florida.\r\nThough winter is more traditionally known as the season of respiratory viruses, the past three summers have all seen increased rates of COVID-19 tra… [+5432 chars]"
              },
              {
                 "source":{
                    "id":"nbc-news",
                    "name":"NBC News"
                 },
                 "author":"Jane C. Timm",
                 "title":"Texas Republicans put Trump ally Attorney General Ken Paxton on trial - NBC News",
                 "description":"Texas will have its third-ever impeachment trial, when Attorney General Ken Paxton stands trial on charges of corruption, abuse of public trust and more.",
                 "url":"https://www.nbcnews.com/politics/politics-news/texas-republicans-trump-ally-attorney-general-ken-paxton-impeachment-rcna102601",
                 "urlToImage":"https://media-cldnry.s-nbcnews.com/image/upload/t_nbcnews-fp-1200-630,f_auto,q_auto:best/rockcms/2023-09/230901-ken-paxton-se-1137a-1c130c.jpg",
                 "publishedAt":"2023-09-05T10:30:00Z",
                 "content":"AUSTIN, Texas Hundreds of people will descend on the Texas Capitol on Tuesday for the third-ever impeachment trial in state history,when Attorney General Ken Paxton will stand trial on charges of cor… [+3334 chars]"
              },
              {
                 "source":{
                    "id":"axios",
                    "name":"Axios"
                 },
                 "author":"Axios",
                 "title":"UAW strike looks \"highly likely\" when contract ends Sept. 14 - Axios",
                 "description":null,
                 "url":"https://www.axios.com/2023/09/05/uaw-strike-likely-detroit-automakers",
                 "urlToImage":null,
                 "publishedAt":"2023-09-05T10:27:11Z",
                 "content":null
              },
              {
                 "source":{
                    "id":"reuters",
                    "name":"Reuters"
                 },
                 "author":"Yu Xie, Shuyan Wang",
                 "title":"China's Country Garden dodges another default in relief for property sector - Reuters",
                 "description":"China's Country Garden made interest payments on U.S. dollar bonds hours ahead of a grace period deadline, a person close to the firm said, pulling back from the brink of default for the second time in four days and bringing some relief to the country's crisi…",
                 "url":"https://www.reuters.com/world/china/country-garden-faces-second-debt-challenge-days-offshore-payment-comes-due-2023-09-05/",
                 "urlToImage":"https://www.reuters.com/resizer/OtpwAR24CpXTKOdf3zvTEyO-i84=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/D5DMTII6YZMVJGVAQZLPKUN7DM.jpg",
                 "publishedAt":"2023-09-05T10:25:00Z",
                 "content":"HONG KONG/BEIJING, Sept 5 (Reuters) - China's Country Garden made interest payments on U.S. dollar bonds hours ahead of a grace period deadline, a person close to the firm said, pulling back from the… [+5403 chars]"
              },
              {
                 "source":{
                    "id":"fortune",
                    "name":"Fortune"
                 },
                 "author":"Christiaan Hetzner",
                 "title":"Europe’s biggest car show was long the stomping grounds of German brands—but it’s now ‘become the China show’ - Fortune",
                 "description":"If cars like the BYD Seal are both premium and affordable, where does that leave the rest of the industry?",
                 "url":"https://fortune.com/2023/09/05/iaa-munich-car-show-china-byd-nio-tesla-xpeng-germany/",
                 "urlToImage":"https://content.fortune.com/wp-content/uploads/2023/09/GettyImages-454120986-e1693843419212.jpg?resize=1200,600",
                 "publishedAt":"2023-09-05T10:24:00Z",
                 "content":"Chinese carmakers are descending on Europes premier car show this week in such large numbers, the German media is reaching a state of near existential angst.Normally the IAA provides a biennial oppor… [+4722 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"MacRumors"
                 },
                 "author":"Tim Hardwick",
                 "title":"Apple to Launch 'Low-Cost' MacBook Series Next Year to Rival Chromebooks - MacRumors",
                 "description":"Apple is developing a low-cost MacBook series to compete with Chromebook models in the education sector that could be launched as early as the second...",
                 "url":"https://www.macrumors.com/2023/09/05/apple-low-cost-macbook-rival-chromebook/",
                 "urlToImage":"https://images.macrumors.com/t/DdbIF0VsQm6aHDIiC3v5NQFk0x8=/1920x/article-new/2022/10/apple-logo-backlit-mac.jpg",
                 "publishedAt":"2023-09-05T10:00:28Z",
                 "content":"Apple is developing a low-cost MacBook series to compete with Chromebook models in the education sector that could be launched as early as the second half of 2024, claims a new report out of Taiwan.\r… [+1454 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"NDTV News"
                 },
                 "author":null,
                 "title":"Amid Sophie Turner Divorce Rumours, Joe Jonas Posts Pic With Wedding Ring On - NDTV Movies",
                 "description":"Fans believe that with this picture, Joe Jonas has silenced the divorce rumours",
                 "url":"https://www.ndtv.com/entertainment/amid-divorce-rumours-with-sophie-turner-joe-jonas-shows-off-his-wedding-ring-4360792",
                 "urlToImage":"https://c.ndtvimg.com/2023-09/390eac2o_joe-_625x300_05_September_23.jpg",
                 "publishedAt":"2023-09-05T09:31:07Z",
                 "content":"Courtesy: Image Instagrammed by Joe. (Courtesy: JoeJonas )\r\nNew Delhi: Joe Jonas' latest Instagram entry is unmissable. It has come hours after reports stated that he and Sophie Turner are heading fo… [+1945 chars]"
              },
              {
                 "source":{
                    "id":"cnn",
                    "name":"CNN"
                 },
                 "author":"Kylie Atwood, Nectar Gan, Gawon Bae",
                 "title":"North Korea's Kim Jong Un may meet Putin in Russia to discuss arms deal, US says - CNN",
                 "description":"North Korean leader Kim Jong Un may travel to Russia to meet President Vladimir Putin for discussions on a potential deal to supply Moscow with weapons for its war on Ukraine, according to the US government.",
                 "url":"https://www.cnn.com/2023/09/04/politics/north-korea-kim-putin-arms-negotiations/index.html",
                 "urlToImage":"https://media.cnn.com/api/v1/images/stellar/prod/230219175914-kim-jong-un-file-122722.jpg?c=16x9&q=w_800,c_fill",
                 "publishedAt":"2023-09-05T09:28:00Z",
                 "content":"North Korean leader Kim Jong Un may travel to Russia to meet President Vladimir Putin for discussions on a potential deal to supply Moscow with weapons for its war on Ukraine, according to the US gov… [+4521 chars]"
              },
              {
                 "source":{
                    "id":"cnn",
                    "name":"CNN"
                 },
                 "author":"Zachary Cohen, Paula Reid",
                 "title":"CNN Exclusive: Special counsel election probe continues with focus on fundraising, voting equipment breaches - CNN",
                 "description":"Special counsel Jack Smith is still pursuing his investigation into efforts to overturn the 2020 election a month after indicting Donald Trump for orchestrating a broad conspiracy to remain in power, a widening of the probe that raises the possibility others …",
                 "url":"https://www.cnn.com/2023/09/05/politics/special-counsel-election-probe-continues-fundraising-voting-equipment-breaches-sidney-powell/index.html",
                 "urlToImage":"https://media.cnn.com/api/v1/images/stellar/prod/230711111523-jack-smith-donald-trump-split.jpg?c=16x9&q=w_800,c_fill",
                 "publishedAt":"2023-09-05T09:21:00Z",
                 "content":"Special counsel Jack Smith is still pursuing his investigation into efforts to overturn the 2020 election a month after indicting Donald Trump for orchestrating a broad conspiracy to remain in power,… [+8803 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"NBCSports.com"
                 },
                 "author":"Michael David Smith",
                 "title":"Deion Sanders: Travis Hunter is a future first pick, elite NFL player at both CB and WR - NBC Sports",
                 "description":"Coach Prime says his prized recruit will be a great one at the next level.",
                 "url":"https://www.nbcsports.com/nfl/profootballtalk/rumor-mill/news/deion-sanders-travis-hunter-is-a-future-first-pick-elite-nfl-player-at-both-cb-and-wr",
                 "urlToImage":"https://nbcsports.brightspotcdn.com/dims4/default/1bb7f67/2147483647/strip/true/crop/3619x2036+0+506/resize/1440x810!/quality/90/?url=https%3A%2F%2Fnbc-sports-production-nbc-sports.s3.amazonaws.com%2Fbrightspot%2Fc8%2F46%2Faceb9c9b439e90c8a8893650afde%2Fhttps-delivery-gettyimages.com%2Fdownloads%2F1657993702",
                 "publishedAt":"2023-09-05T09:13:27Z",
                 "content":"Deion Sanders was a Top 5 NFL draft pick, a Hall of Fame cornerback, and also played some wide receiver in the NFL. And he thinks hes coaching a player with similar talents right now.\r\nTravis Hunter … [+1509 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"The Athletic"
                 },
                 "author":"Bo Wulf",
                 "title":"NFL Power Rankings pre-Week 1: Chiefs, Eagles start season on top - The Athletic",
                 "description":"Days away from the season opener, it's time to rank every team from 1 to 32, with a look at all best- and worst-case scenarios.",
                 "url":"https://theathletic.com/4825445/2023/09/05/nfl-power-rankings-pre-week-1/",
                 "urlToImage":"https://cdn.theathletic.com/app/uploads/2023/09/04134701/0905_NFLPowerRankings.jpg",
                 "publishedAt":"2023-09-05T09:06:52Z",
                 "content":"In a sense, these are the only power rankings youll need to read this season. After all, from here on out, the standings will tell the story, right?\r\nWelcome to the most beautiful week of the year fo… [+32531 chars]"
              },
              {
                 "source":{
                    "id":"cnn",
                    "name":"CNN"
                 },
                 "author":"Reuters",
                 "title":"Woody Allen says he's had a 'very, very lucky life' at premiere of 50th film - CNN",
                 "description":"US director Woody Allen presented his 50th film to the Venice Film Festival on Monday, telling reporters he had had a “very, very lucky life,” making no reference to the scandals that have dogged his latter years.",
                 "url":"https://www.cnn.com/2023/09/05/entertainment/woody-allen-venice-intl-scli/index.html",
                 "urlToImage":"https://media.cnn.com/api/v1/images/stellar/prod/230905093627-01-venice-film-festival-090423-woody-allen.jpg?c=16x9&q=w_800,c_fill",
                 "publishedAt":"2023-09-05T09:03:00Z",
                 "content":"US director Woody Allen presented his 50th film to the Venice Film Festival on Monday, telling reporters he had had a very, very lucky life, making no reference to the scandals that have dogged his l… [+2725 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"NPR"
                 },
                 "author":"",
                 "title":"Congress returns to avoid shutdown and health questions swirl around McConnell - NPR",
                 "description":"Congress faces a tight deadline to pass a short term spending bill and avoid a shutdown. Also Senate Minority Leader Mitch McConnell faces questions about his health following a second public episode.",
                 "url":"https://www.npr.org/2023/09/05/1196342529/senate-returns-shutdown-mcconnell-impeachment",
                 "urlToImage":"https://media.npr.org/assets/img/2023/08/28/gettyimages-1348121246_wide-e1273b0d4cd727707abc08cb8e74b093b151c109-s1400-c100.jpg",
                 "publishedAt":"2023-09-05T09:01:00Z",
                 "content":"Lawmakers have a narrow window to approve a stopgap funding measure and avoid a possible government shutdown beginning in October. Leaders of the House and Senate say a temporary spending bill is nee… [+9182 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"NPR"
                 },
                 "author":"Jaclyn Diaz",
                 "title":"Ex-Proud Boys leader Enrique Tarrio to be sentenced today - NPR",
                 "description":"Prosecutors want Tarrio to be sentenced to 33 years in prison for his role in conspiring with his Proud Boys lieutenants to keep former President Donald Trump in power.",
                 "url":"https://www.npr.org/2023/09/05/1197202616/enrique-tarrio-proud-boys-jan-6-sentence",
                 "urlToImage":"https://media.npr.org/assets/img/2023/09/01/ap23125679073113-1-_wide-e210f66e4b175ad4badb82529c5d18bdf8779c59-s1400-c100.jpg",
                 "publishedAt":"2023-09-05T09:00:20Z",
                 "content":"Proud Boys chairman Enrique Tarrio rallies in Portland, Ore., on Aug. 17, 2019.\r\nNoah Berger/AP\r\nEnrique Tarrio, the former national chairman of the Proud Boys convicted for seditious conspiracy for … [+2822 chars]"
              },
              {
                 "source":{
                    "id":null,
                    "name":"SciTechDaily"
                 },
                 "author":null,
                 "title":"Revolutionizing Organometallic Chemistry: The 21-Electron Metallocene “Sandwich” - SciTechDaily",
                 "description":"The finding has potential to open new directions in medicine, catalysis, and energy. Organometallic compounds, molecules made up of metal atoms and organic molecules, are often used to accelerate chemical reactions and have played a significant role in advanc…",
                 "url":"https://scitechdaily.com/?p=306865",
                 "urlToImage":"https://scitechdaily.com/images/Crystal-Structure-21-Electron-Metallocene-Compound.jpg",
                 "publishedAt":"2023-09-05T09:00:12Z",
                 "content":"Crystal structure of the newly synthesized 21-electron metallocene compound showing the nitrogen (blue), cobalt (red), hydrogen (green), and carbon (grey) atoms. Credit: Takebayashi et al., 2023\r\nThe… [+3267 chars]"
              },
              {
                 "source":{
                    "id":"politico",
                    "name":"Politico"
                 },
                 "author":null,
                 "title":"Trump's co-defendants are already starting to turn against him - POLITICO",
                 "description":"There’s a nascent courtroom strategy by some people close to Donald Trump: Heap blame on the former president.",
                 "url":"https://www.politico.com/news/2023/09/05/trump-cases-defendants-flipping-00113910",
                 "urlToImage":"https://static.politico.com/ba/2d/c5693d3f4d37a4d9db3beabb0541/trump-indictment-capitol-riot-38936.jpg",
                 "publishedAt":"2023-09-05T09:00:00Z",
                 "content":"History has shown the 18 co-defendants that Donald doesnt care about anyone but himself, said Michael Cohen, Trumps former lawyer, referring to the 18 people charged alongside Trump in the Georgia el… [+8336 chars]"
              },
              {
                 "source":{
                    "id":"al-jazeera-english",
                    "name":"Al Jazeera English"
                 },
                 "author":"Al Jazeera",
                 "title":"Burning Man mass exodus begins after flooding trapped desert revelers - Al Jazeera English",
                 "description":"About 30,000 people remain at the site with some waiting to see the burning of a large wooden effigy shaped like a man.",
                 "url":"https://www.aljazeera.com/news/2023/9/5/burning-man-mass-exodus-begins-after-flooding-trapped-desert-revelers",
                 "urlToImage":"https://www.aljazeera.com/wp-content/uploads/2023/09/BurningMan-1693897193.jpg?resize=1920%2C1440",
                 "publishedAt":"2023-09-05T08:39:55Z",
                 "content":"Muddy roads flooded by an unusual desert rainstorm that stranded tens of thousands of people for days at the Burning Man counterculture festival have dried up enough to allow a mass exodus from the s… [+2637 chars]"
              }
           ]
        }
    """.trimIndent()
}