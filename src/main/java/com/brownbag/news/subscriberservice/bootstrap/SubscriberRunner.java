package com.brownbag.news.subscriberservice.bootstrap;

import com.brownbag.news.subscriberservice.model.Feed;
import com.brownbag.news.subscriberservice.repository.FeedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prodmysql")
@Component
public class SubscriberRunner implements CommandLineRunner {

    private final FeedRepository feedRepository;

    public SubscriberRunner(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    //note in version 2 modify this
    private void loadObjects(){
        if (feedRepository.count() < 16){
            feedRepository.save(Feed.builder()
                    .content("SANTA CRUZ, Calif. " +
                            "A Northern California sheriffs deputy was killed and two law enforcement officers wounded Saturday when they were ambushed with gunfire and explosives while pursuing a suspect…")
                    .description("")
                    .publishedAt("2020-06-07T04:59:58Z")
                    .urlToImage("")
                    .url("https://abcnews.go.com/US/wireStory/deputy-killed-officers-shot-california-ambush-71117248")
                    .title("Deputy killed, 2 other officers shot in California ambush")
                    .name("abc")
                    .author("MARTHA MENDOZA")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("BALTIMORE -- \n" +
                            "It seemed easy to write off Joe Biden.\n" +
                            "The former vice president came across as easily blindsided at debates. The crowds at his presidential campaign speeches were far from stadium si… [+7295 chars]")
                    .description("")
                    .publishedAt("2020-06-06T17:15:47Z")
                    .urlToImage("")
                    .url("https://abcnews.go.com/Politics/wireStory/anatomy-political-comeback-biden-earned-nomination-71109673")
                    .title("Anatomy of a political comeback: How Biden earned nomination")
                    .name("abc")
                    .author("JOSH BOAK AP Economics Writer")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("BERLIN -- \n" +
                            "German police have detained 11 people suspected of involvement in the sexual abuse of at least three children," +
                            "officials said Saturday.\n" +
                            "Prosecutors said the group used sophisticated tech… [+565 chars]")
                    .description("")
                    .publishedAt("2020-06-06T17:09:21Z")
                    .urlToImage("https://s.abcnews.com/images/International/WireAP_e6582a07b97d4b8a801ebb0390f5777b_16x9_992.jpg")
                    .url("https://abcnews.go.com/International/wireStory/german-police-detain-11-alleged-child-sex-abuse-71109831")
                    .title("German police detain 11 from alleged child sex abuse ring")
                    .name("abc")
                    .author("The Associated Press")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("WASHINGTON -- \n" +
                            "A stronger than expected jobs report could further scramble an already uncertain picture for passing a fifth and possibly final coronavirus aid bill. The positive statistics are feedi… [+4568 chars]")
                    .description("")
                    .publishedAt("2020-06-06T17:09:21Z")
                    .urlToImage("https://s.abcnews.com/images/Politics/WireAP_eef744ab6f3e4f24b35d57d578e6ccd8_16x9_992.jpg")
                    .url("https://abcnews.go.com/Business/wireStory/jobs-report-diminishes-gop-appetite-virus-aid-71107981")
                    .title("New jobs report diminishes GOP appetite for more virus aid")
                    .name("abc")
                    .author("ANDREW TAYLOR Associated Press")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("As George Floyd's death focuses renewed attention on the African American men who have been killed by police officers across the country and the deep-seated issue of bias in policing, advocates are a… [+9191 ")
                    .description("")
                    .publishedAt("2020-06-06T09:20:00Z")
                    .urlToImage("https://s.abcnews.com/images/US/breonna-01-as-ht-200513_hpMain_16x9_992.jpg")
                    .url("https://abcnews.go.com/US/breonna-taylors-death-black-women-killed-police-encounters/story?id=71057133")
                    .title("After Breonna Taylor's death, a look at other black women killed during police encounters")
                    .name("abc")
                    .author("Christina Carrega")
                    .build());


            feedRepository.save(Feed.builder()
                    .content("As George Floyd's death focuses renewed attention on the African American men who have been killed by police officers across the country and the deep-seated issue of bias in policing, advocates are a… [+9191 ")
                    .description("Mukhtar Ibrahim didn't imagine the communities he covers would be at the epicenter of protests sweeping the nation when he founded a startup news website in Minnesota last year. Now Ibrahim and his staff at the Sahan Journal are on the front lines.")
                    .publishedAt("2020-06-07T05:11:41Z")
                    .urlToImage("https://cdn.cnn.com/cnnnext/dam/assets/200605155800-mukhtar-ibrahim-super-tease.jpg")
                    .url("http://us.cnn.com/2020/06/07/us/minnesota-floyd-protests-sahan-journal/index.html")
                    .title("This Minnesota journalist says there's something important the media is missing about protests")
                    .name("cnn")
                    .author("Catherine E. Shoichet, CNN")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("It's past midnight in New York and Washington, DC, and evening in Los Angeles, but big crowds are still out on the streets " +
                            "in both cities, and spirits are high.\r\nIn New York, protesters are marching … [+1973 chars]")
                    .description("Protests following the death of George Floyd, a black man who pleaded that he couldn't breathe while " +
                            " he was held down with a knee by a former Minneapolis police officer, continue. Follow here for the latest updates.")
                    .publishedAt("2020-06-07T04:34:40Z")
                    .urlToImage("https://cdn.cnn.com/cnnnext/dam/assets/200606230925-0606-peaceful-protests---pittsburgh-super-tease.jpg")
                    .url("http://www.cnn.com/us/live-news/george-floyd-protests-06-07-20/index.html")
                    .title("Live updates: George Floyd protests across the US")
                    .name("cnn")
                    .author("Jessie Yeung and Jenni Marsh, CNN")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("(CNN)While protests on Saturday were mostly peaceful, Minneapolis Mayor Jacob " +
                            "Frey was met with a chorus of boos after telling a group of demonstrators he did not support abolishing the city police d… [+1488 chars]")
                    .description("Mayor Jacob Frey told a group of protesters he does not support abolishing the police department.")
                    .publishedAt("2020-06-07T04:34:40Z")
                    .urlToImage("https://cdn.cnn.com/cnnnext/dam/assets/200606221242-minneapolis-mayor-police-abolition-super-tease.jpg")
                    .url("http://us.cnn.com/2020/06/07/us/minneapolis-mayor-police-abolition/index.html")
                    .title("Minneapolis mayor booed by protesters after refusing to defund and abolish police")
                    .name("cnn")
                    .author("Amir Vera, CNN")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Instead of funding a police department, a sizable chunk of a city's budget is invested in communities, especially marginalized " +
                            "ones where much of the policing occurs.")
                    .description("(CNN)There's a growing group of dissenters who believe Americans can survive without law enforcement as we know it. And Americans, " +
                            "those dissenters believe, may even be better off without it. The s… [+6278 chars]")
                    .publishedAt("2020-06-07T03:19:07Z")
                    .urlToImage("https://cdn.cnn.com/cnnnext/dam/assets/200603071138-02-george-floyd-protest-0531-washington-super-tease.jpg")
                    .url("http://us.cnn.com/2020/06/06/us/what-is-defund-police-trnd/index.html")
                    .title("There's a growing call to defund the police. Here's what it means.")
                    .name("cnn")
                    .author("Scottie Andrew, CNN")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Image copyrightReutersImage caption\n" +
                            " A plain-clothed police officer confronts a demonstrator at the Rome protest\n" +
                            "A rally by Italian far-right extremists and hardcore football fans over the governme… [+1904 chars]")
                    .description("A rally by extremists and football fans over the government's response ended in clashes with police.")
                    .publishedAt("2020-06-06T19:34:57Z")
                    .urlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/A555/production/_112752324_061829302-1.jpg")
                    .url("http://www.bbc.co.uk/news/world-europe-52951920")
                    .title("Clashes at far-right coronavirus protest in Rome")
                    .name("bbc")
                    .author("BBC News")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Image copyrightEPAImage caption\r\n There is long-standing anger about alleged mistreatment of " +
                            "Afghans in Iran (file photo)\r\nThe deaths of three Afghan refugees in a car fire in Iran has prompted an ou… [+2348 chars]")
                    .description("Three Afghan refugees died when Iranian police shot at a car, causing it to crash and catch alight.")
                    .publishedAt("2020-06-06T17:49:33Z")
                    .urlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/59DD/production/_112750032_tv061424853.jpg")
                    .url("http://www.bbc.co.uk/news/world-asia-52949429")
                    .title("Iran police condemned after car fire kills Afghans")
                    .name("bbc")
                    .author("BBC News")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Media caption\"Fifty plus years later we're still dealing with the same thing\"\r\nLarge crowds are " +
                            "expected to protest in Washington DC against racism and police brutality, amid rising anger in the US s… [+9550 chars]")
                    .description("Large crowds are expected to protest in Washington DC against racism and police brutality.")
                    .publishedAt("2020-06-06T15:40:40Z")
                    .urlToImage("https://ichef.bbci.co.uk/images/ic/1024x576/p08g7158.jpg")
                    .url("http://www.bbc.co.uk/news/world-us-canada-52951093")
                    .title("US capital braces for biggest demonstration yet")
                    .name("bbc")
                    .author("BBC News")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Image copyrightReutersImage caption\r\n Thousands of protesters have gathered in Parliament Square\r\nCrowds " +
                            "have gathered across the UK as protests over the death of George Floyd get under way.\r\nProtest… [+3901 chars]")
                    .description("Protesters have been warned gatherings of more than six people are unlawful under coronavirus rules.")
                    .publishedAt("2020-06-06T13:51:24Z")
                    .urlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/E8CA/production/_112749595_hi061820195.jpg")
                    .url("http://www.bbc.co.uk/news/uk-52949014")
                    .title("Thousands turn out for UK George Floyd protests")
                    .name("bbc")
                    .author("BBC News")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Image copyrightGetty ImagesImage caption\r\n Pope Francis has suggested the property deal was corrupt\r\nAn " +
                            "Italian businessman who helped the Vatican to buy luxury property in London in a controversial … [+1602 chars]")
                    .description("The Vatican's £160m ($200m) purchase of a London apartment block is the subject of an investigation.")
                    .publishedAt("2020-06-06T13:41:06Z")
                    .urlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/11945/production/_112750027_tv061769130.jpg")
                    .url("http://www.bbc.co.uk/news/world-europe-52949421")
                    .title("Vatican arrest man over luxury property deal")
                    .name("bbc")
                    .author("BBC News")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Scientists are gathering data on how new diseases emerge in the hope of identifying future pandemics.")
                    .description("Scientists are gathering data on how new diseases emerge in the hope of identifying future pandemics.")
                    .publishedAt("2020-06-06T11:14:08Z")
                    .urlToImage("https://ichef.bbci.co.uk/news/1024/branded_news/14ACC/production/_112748648_p08f25v3.jpg")
                    .url("http://www.bbc.co.uk/news/health-52786714")
                    .title("Hunting for future killer viruses")
                    .name("bbc")
                    .author("BBC News")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("The victory of Duplantis, the record of Warholm and the race of Johaug: what was the memorable exhibition tournament in the framework of the Diamond League")
                    .description("Diamond league")
                    .publishedAt("2020-06-12T07:11:07Z")
                    .urlToImage("https://cdni.rt.com/russian/images/2020.06/article/5ee2919aae5ac93f383a73e4.jpg")
                    .url("https://russian.rt.com/sport/article/754498-brilliantovaya-liga-oslo")
                    .title("Hunting for future killer viruses")
                    .name("rt")
                    .author("RT")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("All his words can be refuted ”: the former wife of the ex-football player Schalke told RT about the staging of his death")
                    .description("Schalke")
                    .publishedAt("2020-06-12T05:30:33Z")
                    .urlToImage("https://cdni.rt.com/russian/images/2020.06/article/5ee23d5302e8bd533b0151a7.jpg")
                    .url("https://russian.rt.com/world/article/754376-zhena-futbolist-inscenirovka-gibel")
                    .title("Schalke football wife ex player")
                    .name("rt")
                    .author("Yana Dovgalenko")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("In the spirit of the times ...")
                    .description("Russia Day is celebrated on Friday, June 12th. Vladimir Putin will attend the ceremony of raising the national flag on Poklonnaya Hill and will award Heroes of Labor. This year, due to the COVID-19 epidemic, the holiday will be held without mass festivities. For Russians prepared ...")
                    .publishedAt("2020-06-12T04:30:05Z")
                    .urlToImage("https://cdni.rt.com/russian/images/2020.06/article/5ee2af16ae5ac9634230fec3.jpg")
                    .url("https://russian.rt.com/russia/article/754481-koncert-fleshmob-den-rossii")
                    .title("In the spirit of the times: how the country celebrates Russia Day in 2020")
                    .name("rt")
                    .author("Roman Shimayev")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Vladimir Zelensky said that his predecessor, Petro Poroshenko, was an\" experienced manipulator and an experienced politician, \"so he is not trustworthy. According to Zelensky, Poroshenko sought a meeting with him and offered help that the current Ukrainian leader ...")
                    .description("Vladimir Zelensky said that his predecessor, ...")
                    .publishedAt("2020-06-11T21:47:00Z")
                    .urlToImage("https://cdni.rt.com/russian/images/2020.06/article/5ee22d6c02e8bd4a3f7db40a.jpg")
                    .url("https://russian.rt.com/ussr/article/754374-zelenskii-poroshenko-prezident")
                    .title("Experienced manipulator \": why Zelensky declared\" distrust \"in Poroshenko")
                    .name("rt")
                    .author("Aleksandr Karpov, Alona Medvedeva, Maksim Lobanov")
                    .build());

            feedRepository.save(Feed.builder()
                    .content("Vladimir Zelensky said that his predecessor, Petro Poroshenko, he is not trustworthy. According to Zelensky, Poroshenko sought a meeting with him and offered help that the current Ukrainian leader ...")
                    .description("Vladimir Zelensky said that his predecessor, ...")
                    .publishedAt("2020-05-10T21:47:00Z")
                    .urlToImage("https://cdni.rt.com/russian/images/2020.06/article/5ee22d6c02e8bd4a3f7db40a.jpg")
                    .url("https://russian.rt.com/ussr/article/754374-zelenskii-poroshenko-prezident")
                    .title("Experienced manipulator \": why Zelensky declared\" distrust \"in Poroshenko")
                    .name("rt")
                    .author("Aleksandr Karpov, Alona Medvedeva, Maksim Lobanov")
                    .build());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        loadObjects();
    }
}