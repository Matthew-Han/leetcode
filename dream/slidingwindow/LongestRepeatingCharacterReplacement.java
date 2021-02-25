package slidingwindow;

import java.util.Arrays;

/**
 * @author Matthew Han
 * @version 1.0
 * @description
 * @since 2021/2/23 17:32
 **/
public class LongestRepeatingCharacterReplacement {


    /**
     * #424 替换后的最长重复字符
     * 执行用时： 2587 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 39 MB , 在所有 Java 提交中击败了 5.21% 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {

        int size = s.length();
        int ans = 0;
        int left = 0;
        int right = left + 1;

        while (left <= size) {
            while (right <= size) {
                if (right - left - maxCount(s, left, right) <= k) {
                    ans = Math.max(ans, right - left);
                    right++;
                } else {
                    // System.out.println("left: " + left);
                    // System.out.println("right: " + right);
                    break;
                }
            }
            if (right == size && ans >= right - left) {
                break;
            }
            left++;
        }
        return ans;

    }

    public int maxCount(String s, int left, int right) {
        int max = 0;
        int[] bucket = new int[26];
        for (int i = left; i < right; i++) {
            bucket[s.charAt(i) - 'A']++;
            max = Math.max(max, bucket[s.charAt(i) - 'A']);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ZUOYSIMYEOJCWKXDBMIMGBEIDCJCXUASSQQDQYWFBIUDIBEIJKYIWZXTHNUDPJLMSCJADQMGGWUPBZLVMTGENKBWVVPLQRUKLFTLQTNRVQBOZTMYKAFVWURNEOOXEKBAGHOWPLLOMNDBSLZQYACONTAQJHUWXUJQLBRSNWZRRHUAZHDAWNQUTVMHAQQMEDWGFYWRZFRHUVCOELPIAWGZJTSSDYZMGFLWBDBPVLJWIBMXGZIWLKJGTLLGYFTWRYLARYPSJOOKBUFPPYPHMHNNPURRQDNFFHNNYOAGEOCYBDSPVPZONVVRFHTXJAMZULHVSKDEHTYQNFQAGRHLSEAPULKNRAVGWLREPAOFPFFYSCUFQRKXHVBPUQMYROYNLRUABWOLZRRHJGESOAOXOWYREIWVSCOAPFLBYEPHKCEEWPFEKXUHMQENLRBTMJUVPTZAZXRVBFHXJVTAVHKKLBXUMTJWUDKRQXCHYIOXUELXHUKLLAPYGDMDHEULPYGCXNIJHIRQIPULFTUBSLYPGOYDYQEAJQIDXIXWLTZYYHCLOGNXDWPQDJPQCWOSAYZYMRIZJPKLEURTCUVVDVXHBISKKLMPAHQAJUNVTVPNGPBEPWNYIGMMNEEYKSLYXBQANMOEHWDKMTIWKLPDRHXEFRAEDUASBPMDAIIPHZSLNCRWGKXQXFUBIMFVYMXTRYOENKOMQPYUHERRYNDAAOGSXQWUQBQGXKGFDWZRQHTJYUCEFLWRQHEYKMDUEWDEKMZNPLFZFCJNQRATKLWIOCUFPVAVYNMYPAPJROZRDSAQTDPXNIKYRUUFPZBNWTWSTDHDYCMRGTGYUHMXMGTHYKSDQUQWHVHONTAXRIMKMYVNXNMZLBDDIWBADFULEPSRZTOFFGGGAYLSJEIDXZFCJNESCINQEMNORQUCIMDOPQJKTVOULGYVURXGUBZBVMAJAPDMCEOLBJROSTKFCKFDSZEVOILOKBHRNYVXZLXXEIULWLZGADZRIBIDAHABYOCZZBKCKWBNULFANFSORFMAEEMPSGAPLNXZEYADRRZBVQPJCKMWWKETGQMDHDDQLEUHKISWPJJGDUEIEWBGSXQYRRIFKLJJSLLTLDOSSRPJRKDHSHXOEGAIDWCIOOBDXHGTKNNRYWHFQOLBKMKIRPDISWJMCUEZOKAUBYEZLVJGQERFHMOBXVCFGPCVHJDOOKWXPZGPPXWZMCXPGAFGZAMDTLURHSRYLPUQYYBCKUZLKKDOQFLYSWFIXMVLOFMHLORADYXFLMMCHMYATMTGDAYLLWGLJUSVMXBBPCGLKCFTZKAVPTBYGRMEPKJKFXZVJTWISPXUXJNSKBMVSCNBZWYOLTAAKGZZLROHOSGKZNRCJZYXXTTREQTIZVTXGHLLZFFEUOMMJMMNPDKPUSYAHLTYIJQHLFXBVTJDULDIGGBLDUEPHQYSCWUMIXRGGFHYIILFRWWYVNGLVTVSQXIBWQSOEHDGMGKZVYMJAOTTPPTCJKLGMQHAMFZRIXFCMMBJHELXVADBVNMFIJSAGWUNDFRPXZLHVPWJQWPYKCELNYBBRJLZAGXBHFMRERLYCORWJEURRYWKGPOXWDYBWBZOQHDJZLTRERWMPPSVWMYDEHARRYPDRTBMCEXROYTNAMFXFNHJGZDRDTGLHYATMECLRSGBSLWKSRCRQNHGIZDDQKQKEYLEQJKBTXRZVANEDBYEWVSZNINSBIGVFUSFLDLZEOPFYHQQICGLDKHMBTGCVEJWMRSGUNGIKFQSKOXZKPDVSJSWEUBMLCQUZOUOOOXTDRJJBUUDWPYMLICTWRBYSUDECXEPBIGOBFXFIXNUMTZCCPWOEGLTZHADACAHEOSZNDAYWEFEVMJFSCJIKYDJOHUIWRAILNQXCWVQXRUAAWVAZMUMVJUAZJAIZGLRFCCWMCVFTQXVQNUOWNXUCJCWAUFTVHKJTAQSNABZFXEDWMROVKAJRBSBQHKQBYCEZLDJGANHFNJNGJLJWWJGAXPTKTTARKNSFREMRMPLVSVQRGRHXFCTRFWSOAJJNROPPCCLOTKXNJGFSQKKXBNWARDAYWOUKQEDTNHCXTJVGBTNYUIIHLWIQSDKTHNXZVINGIEOBZSYFKZTCJDUILQRQCZLRVVKNGZNQYFNIAKIACFDSNJOMVLJUULJKSRMOZLMHBJARVARTEXUMPOYYAQHMUVLRYPLFSJRIDCWGKSETHDOQHQRPWSVATJQBNGHBRRVOVSKDQEITNSUMHXBNXFATCUIOMILUCZGCXRTFTBXWPPHPANZNCPCQCQRJNOSXVVBKHQWYDUCLEUSECYSWKWIXWDAHLWULQWVXKWEGGVTZDBCLBZCKSFBNOIFOIRJZZDEZDNTKALDVHWQROECHVSQZJPMGMVVHGUOUWBAJMWNWDFSHVIKIDJDMIPLXTYVWNKPMTSAJRQLFJOIUGOCTSZEXJTQBBIWNUGQJIKEJVTTAVYUKKYUYNOYQLCNZZOJPSSSUOPIWPHGQWETRAQINASRIOANRXITIVZJOIZXEFIPTKOQIDGEQKPIDGMUJWLSDCMJFFQVOIGIVVYGVOKMJAKRZHOSTNTEDLNQGPPOMFQNZNPTGXFRWXXYXBMOSKKEMBHNYGRODETZCMOWXVQMIMUITVSRNPKZMOURLVWWYOIYJLXTCOJFINOXWHENTEQOWADUQLFOAQXGODPBGQGKAFXSSWQPAUEQLECZOXDRDGEBQLVCTWGTNGNVBJRBQVOLOAHYKMITZBDZRFTOHCKNJVGJGHFAJVEXFWXTQXJFPVUANGYWSCUYLLONPMOLKHTURXHVKLLNWAVPZCGKOZFUUXFFNBNIOFXWHOVIOAWTFRVXTMEKDLZZEEIBOTAVRJBEATGUHXATTLZYLUNDEUTEHDKYMUZDUECJRGZYZEXKNALAHWQHGNNWLNCICGYJKYNIJXSGTCHUZYKRKCFBFBWQOVFYSUWPJPRHAVUHNUGINQUZIVKVKLOUWOUBQRQLYFQPJANSBJFFOEDSSRHBSNMOISMAELZGOSAWTHXOCLMCNJGJIICIFWYSILMOOHBSUNKSRYHBZPAKFMSDAPGZTOPNOARYNZGUCFGRPELKICAUOHSETZOPDRJVHYPZDLCYVSRXGHAWXHXZEZLJIBVTRVPDOOQTNYJCEQVWSLKMRFVEZKMDDFSZJBUBFMRPOKBRVUSNNIVFMFGFBQHSSQUVANBIQZYGOBKYGEPTYESAAUBLICBJJLHPXLDNROSORNANUSXVXGKTWFAKRVXVHTKQZYJWMFNBRFQXKFZYNOLANFLIBTVSQDWPUWHPDNIGJMYAOYJVFJUSCWERJLQEYDFNRATPSHUUBQNSVKACCPMVZQDHATACBGBNHJQAHAXVRKESKHDFKAQGGFFAYHNXXTDLLKSQWJPIXPECRKQAFWZRTHQURVFUTXNPOZMIDFAPOBSHNWDLBDBCNQYQSZEWXGTCQPALRXOBJKGTKLRGZCSILWVFCWSNDBOKDOYLDEKTECQLVHJVYMRDHNIUZKTIETICFLGFDJJBLRKWJTTMRTCPVFNIKJPXNTLZSLRCQDARJZZFAFGQNFFKTMLXKXEFPYVKQYWHFKMBMHQTBIDOFDQSAEVRFQFXENTZUBDTPVYWGNPYDCJBDSGDHWLJDEHYQRMDCNMXUDEKLMNITBXHDWSIFMFCWYHSAWDJLEAMKBNWOGUFIKXLOFHLXAWMHLIOVSEEIWXRSEUKINREPDBQDGWCCTPSSEHSGLWKVXKRMJCEMHUGLZRQSYXELDIMFLETYORGWYXCRXUYOBIDHBPLRVZMBIAXBLYGEGCZDBGXJSOVTDGXQUTFZNRIMDCODUNUFEUGQACRFPHULVPNPOSGORFKHPNBSFLMWERFFVCTTYSVPIOGWYCPUSYLSLNNJKPCIGUISNPMBNJEHTIRANJMFRGGNXRUDHLZFMXYAVQSBLQJHDSBFDNIBTSKHGPGOXQFTIYGVLKRVFMFCTIBMFSHJZASRLNDFXZFKTZEOTJXKTVVAQBRYWASKSXCXSZQBMOBOLOLPACTAOEOVDGDNWHQQUBHAATRVRKHJJFHYOPOTBNKGBRXHMRVUZJBXQUIWZPBMQWJFVNVCTLWSXIDISOUBCUWNLPVYBXJFNPXLKHZAXCOPQLMBWVPLAHBLKDTXSFECCSMLAXIAXCOZAUZMPLLAHGVFVVDXRRRFWBFVUEAVTOOCDLVWPAICJQPNAIHUMXAPHXQGBKXNAINVREKCSZYNGGPMCVZVQWYNRASQHZRZTLUGNXQRGMZDIXQYLGCSXVBUNACOJAVBZASZNBJITPKZDCHKPEDTVBEXEKWHNYGCXGLALNUYCIAHFFYSCYFWCCJMZMCDOJHHWFKLRXVWACPZONWEIEUZHFQXHHJGFMIGVOYRUMUZTXTCQLGAWYLYNHEPOLFXHLELCRPBBFKDEOOXTXBIOXSIWQEPYUMMCBPLILIWRBOZLVWWLSNOBHBQQCJTHATTNADVTFGWMDUDIDWQPCGHLYWIFYYOKQCEGBERWYDLGNMNLHOVXGGLVSEFNJFHFIFRUCAQGNVPBKJMYLVAKFXUAMVIWGOESSZZERMSCWSBLHNFMBYHXNCOKLASXIGOXUVKVTVQTZFRGHCKKHGDPXVUUIZGCURNOKGQKEWGLMDHRYAQIOWKTRGFKQCIUIWGMAKUSCBMAJXRKDSXPRBQPACXPCBGEVSDBQXKAGQNDHBAYMVEKVWWUPDUZCZOOQSBERTDMZUNXQGYUPPRIHFTXVJYVHTJLVRMYUZHHSWZFOXXEFDZYBTKPIRLRIWDMXTGAIIJMIOXXKYHGEWTUDGSDIIEGKKMJXJGKHOBQYQEBEAWPKRPGQHIRCYXMMWVYWBERMGGLVHUIFMTYPBPQKVNWCHWIYBXQRTNWKGZNAEDCAIXCFVBJPNIBTVJAZFADSQCVACJNKJZPIAHKRQNWKGFXOMQALEMKBIAFSFULYHVFSANAJAYIFYLADPDATAPLVERZSLIVWAOCAEQTUJUGJWPFIHVCJTKDZAKGCIGLUEJQPPWWPYWAGDHJHCMRLDOJOAVMBTLARCIUWJEQSCXQCUQYHHORHERTAIHRFTIGBKNGOXCYCSIJGTMIVFWTNKOEVUUVQXXIORDHAQIAOXNFGQVNVFXYANQILKFOYMJKFESMQSUGCHPKUKAZEXSGPSMQPGUJISPTVCGTNRLWMQMRYFYEMMQUTIXUPJNZEYBXZAJHENCDOFMAAEIQJAFPIISNSZVMGFGRCXUUOQOIERJBSHXSOUSPFHHDQTOOWMPJJNASMMZWMTIZSTCYCEQYFUVIFOLPKAHSULIRCHQNESXCZJREEUEPQCEQKGOWMOUANHLSSDGYBWLPOVLUWIGHHMVNJLZLCGGMLLYRQXEMONNRBOCIHAOQPYCURIQLYPJYJWVAGFZWCWQSEXIRCIDTPGZOVYOVRHVSTWDVNRFFHGOFXGPAGNFFOTRHTZPQOZPCFXOFEMJMFHXQJHMJJNWSKWLUPWNCAISZBJJSEIVZBIJDMZXYNYLGVMHMPULEVTBRUUCNYBWMQAOXKLAARQYYPTSNUMKODTDNEHUSVSGINVJWFXBXUTZSNFZMXDHZESOJGYZQZLVIDSCWSNPFKWPJVENKNDWIOBBIRXBWJTWZBKQCIAAIWPBKLKGYVWEOWMOGPNQLDKVHYYRLYBOMKQNJPQJKQUNZVZPEXOKLTRVBZEPLGQYJJYAEMGKRIFQAOWYQOOHQGUGXUTZWHNGTTKIWXUCUSJFIXZOMGQCMQEJKCMXWLPDXSGEEPPIKKVSNCWTOQPQHINZPPJLDVULDTMRDBUBRYGUCULZGOTMDIMAERDNVRLDSTQOVOCQGYXOLXYBADVMTEOBJUVSBGNXRYLWUUZVLFQBBHVYDDAMGIYTRQWMEGDRMGMAENRCJSCBOEHJQGSASFVEAAEGOFSKJZOEHFGPEVLOJYFNRFVJOXHABGWLTVVJBVNYVKXAHHWNWSCAQXCJLDVQTKRZWPGTKALLZMVBMMHWHOZOOAYCICKEEXLLBHXROJIWCOAUNPLAQSYTERGHXYHFJTVMYZHXLJQXJYFUHIJYNUEGWMFPFODMYDMFQXPGRWELAIAVNUECPUZJODUYHBERJBDNZSGONMCLOCQBVYHGOOMSAIAHWIUJTBBEXPTUTTFCLFRHHNMAZKVMRUMNYEWAMIHFRUQZTNMQRPUTPUUJXRBMLUXFVKTOZIMZCQVFYKEMTTLCVRIPBGDHAXXAKOTFAFYLBLHNJSCYPWWIIJFQCTEXJCDHNEBCYCWJFLSLVLACYXJIBBBFKQXSPOXXWNBDRLFBLRUFDVGWGEDEYUPVOMNWLRRGEQXJYJLKSYXXVANCYTYZREWQXALQSTDUDYDMIMAORRFLIIGXATBFGPUTAMVHAXLEIPGXVWQEJHMZDSHGXPONOZJRQXTFKHYMZJWTQLQNYMFSMCNMOHBPRUEBAPZINHJAWRFGJDBCVHZOUJSBABMBAWJWDNSXQCXTFRMCDDDQUAZNDZMTMVWXUVSVZPRMKQMCBHTWDUSWUDMYKQEZYWTHFOTAFRXWXEHMRBXPSJYQGQVEIWNMACOJMLCFELSDQMLUJLDCTGEOXCWCKSPEKQBXWNWWGWJMKULWQGCVXDAVEFXFFXFLVAZBOLAQMYPTDJAPETUNQHPRWTDOUXXYDVVIFXFBPZBEYWVRDHGWQIVROSOXMKTDKKAOXGPNFFNMNODKMFAKQQNSVSGZUKSAVNTRCYCXDGATBFPLDJBPOUVXUXCPOOJLLPDUGUHLLWZFXBSGHHLHLSZHPRUVRRHICMOSHUNLDMOLANLEJJSSRQBHVQVEJJQWQTLWAKIRPRJFXYQNTANOTRGTUVSBOTAAEOMEBDLEHVSZWHHNLNXVXKBRBIRQVADTBVFYKVMZDCMXAUBRRQWCTHEDNIDGCNPYEGGTJZECIGUONGLHHHARROXLESSADGPTHREYSTQHAXXDTBRIYICHTSRODRMAHTMHYQIOJDXKQPKUPGZQTQJJMSEGATFUABSQJPTJIIZVGBTHLPWVEUMSFPHTOJLMTYVTXGKLJIEGFGZMARVOXDDGUQYYFVKALRHDDIEJPJFZJTXTCFOUFMRHDOTYODCFYWWGHTNRLFBHJQVQQNQHNRZXFZASIQXVQHNWZMMCZCRRONQDQZOQFAIXQWXYIZEYYMJNWDUAUTCWKDCNBLSXUDRVHYATAYKSKDWYMFQDRKEQQRHFNNSLMFHVUUAIUMRFXGOIMGKWNQPAJJNPFZOWEIUABWRNCJBZMMYMXOHNJOVMIRZSPQQUBKVUIHSZYEPNPYDMCLOFKTRNIODVDXIVVNCUOUVPQNTGFGMSRJVVDHWUUSQQBJOIPYSIFKMAFPPTWQYBRPECIOKMQHKPADJFWGNTIDBGBCNEFPOURPFUZFYKEWCYZISRCVJYECVYVZHLSTNRPNBEOJPBLMNPRIIIKHMCYHEUVDASJROSJQTMBOFURPNQDAAQYQBRURUKLPKIPIJSTCGRLYGOPPUENAAPAVIOTPUAXCSGFZJUDHSKITUCSRRQYEUSMNVNMNZMCUESXJRRMBTSOAJILXWYWZUTRBOIMNNKTAEKNOCJBNULAAACJRMMQXLDEQIDUWJMTOUXAHQIPYABYVCMFHVAQRLAZZUNKXUQTVLZLKULATQFHROGDSYMQNAEOCXGJAQVHXSVQFCNGAXDBCPDHNNNSZVXSBOEAWDCPQXSJSZCQXZOQPPVJUOODYWTLBOMSGAXSJJSHBMDFMHUOCTPDLKBALOPWQWQUYCGTFTTLDWBEQSBMJASDUDSFROLXMBYIJXRAXPHPZQXJEIAWJCTFLJRJYRRCUSEKBLHDOLEDWISTLRNXUQBMFYHUBKJELMESEYIHAFBMPTTUXGUDIYEJDLPBSMOIEJDFZLJOTBGDIROIUEDDWXAFKRBPKWNUAHEBLGCCRHKPGWSZAPJQZRIDMJKKCMQOIKBYCZITYFWZMSKKYCAFMXNKGLRLFCVPNBFECSEYUYLENWQIEKCNABUKZTSHJUEGQIWVGIJHETVOVIYJSTOSRASRNFJEXEEMVDLZXNUHQFCPNGYLGOQMEGPAESQZEVDAVCFDEJWPQYVBVMRQOZYKVWANCSSLNELXCYERFMPXZRFNQPYACTGPZMXIEZJSTRRHXCWMBWQVTDFAEWSAEYIRTZBGQEWTXGLZKFEVSXVCXBSUFCOMXBMQTDNCHXSQHJZYWNIBEYMNRVDUIQRVNKVVXBLATACHZNLOSSVJMJFUXPTSINNUJEFVOWHWPXPWOBMHRDUZSVHRWZYIOBVVSMPOBSWLEYXXKWTYBZYCKCXKHIZOMKWJYBTPOLDUVBGDCNJJVFLQEFUTGXAGAQIGOACTNUTDJMXDYFWZZCBLGMGCNLBORTRRNYCGIQSDDRTOJTTCZDNTDFWKMOBMUWXILASOKHSASROIXAIBOTDUMUQQJAFQLYZBRRBJKYSUFFYNQSAQVMJGEOLORHKQCGNWKCYHIXTMBNIMPSMYJEDTNPUAIYHGVANGRMRKCAGBSRAMBGGFQIXPUOFCGYOPYISYGZGZZONRCKZTYFSVSDBWQDCGDNZYOFFODSSCFGEVIXCVYIMLKELMGKJOJHLQIGSAFSAHKDNVYAKZKWGMUXHNXMXXIASKTDOSGVTLXGNFJKKIOONGBUFPWZTUCSLBYKCPWKGEJRHISGNWOYKCCEIAMWNYIOASAKTPMYYVVJUQEZWRGTAZLSKZPIAXHXAJLFRWILSHGYZZRHYKLJJXOGITWHLDJTGZLQBESAFDPUYHZPMGYKNMQLMEYUAWWOIZLAJPYDNRNOMNZMKJSJVVETXEPSRGLQEEIZUUMZLCESBHUBFVMFIVJWPNDFKKTTEZLVWSUXDUENLBRWBRNIVZZYZASCOFCHBEXRXSARPXBCIJQBQAEVWATSMUHESYVPFPMKZKFUTNNPEDEGQFZVVGDLEHWIHRITMZYAWBIBUOSLBVBUIIGSXTJEGWKMWUXIPIWKTRKYOXWLAYWESAFOTZJOQQGFMRHJILFEKNZVZQWBYNTNKEXYBCVUJHSUMLFYGCECGZEXWQPTDQYYZXMFIRDAUGKZDSXNDGJPYLSCYCXOWYTZVTWNAJYGSCWRAFDKQGMXMTALQJRWBZFKMEKHZHMNUCFSGMSDKUIIBSXOWVDTOECUKWCWXRXBNWAQWSDMYEAAWEJTNCWIIDOYZCVJAJEIIZCEBATLZHZFZAMLOIWPIBPZMEBLKTWZAELPCSFNEIDVGNEYXIYOQCBVPHGZFAYJFOQAVAGXOFQBKFMWOWVNVCQLQUVNJOKCXAPNZKBLSWXKHADPBDLVYFLWXQRCYIXVUORZCEMPZYFLXOBCZCJFVHYQGTNBBHOSRFXDDIKSRXFRKPUMNTFPKUOYKOUXHTXWHUCLEAWIFLZETXUMMMSLEYWGUELYDKAVMQMNVXXDPZWQSNKHBTJOHOBNMWZBMUBNPZBRDNNEPRJRJISXDTDSLGOIBAYRYBJRPEVVMCAUERFLLWHSIRGQQNRTASMOTBJYAZVUOWYEQIUFGZVSHVJWGCRYGNCICBFCFQGEUCRRIAJLYHLLVHTYINSJRHBJHHBMGZQOABYWUCBTHKZRFJOUIRQIUOYQGOFVVXZFIQGMZOMOQRNILYPULKNOGNVDFFXFGXCPTZZDCMJEIWKRAPFPFDVOKHXTZDHOJONEBXQVXFKVSURWIZTCZKFQMLZFVZTWPNYJQVYRDMYXERRIHYMUOWYGSYXUONYPGUIURJBMNVEFGYEQQATRVXDXFMQMHEYRAJTURIZVOWQPGDYWCUFCCUXAESBGLQESMPYDYHMOTTIJKSJIHJRIZFTFEWFEWCRZEJVHVPWEVIUJSUYPHPJGHENQYGPWGKNVETQQLLDPKMNSQPOFNSFBEQKAHELAXGMJAPBVNNGTXVXVVUROCVOSLRLGPIOGYBRQNUAVLEPEEMHKTZZILBUPYHVU";
        LongestRepeatingCharacterReplacement demo = new LongestRepeatingCharacterReplacement();
        System.out.println(demo.characterReplacement(s, 4));
        System.out.println(s.length());
    }
}
