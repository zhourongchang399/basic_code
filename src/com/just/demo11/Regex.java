package com.just.demo11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String phoneNumber = "13729921390";
        String phone = "020-2324242";
        String email = "497447111@qq.com";
        String username = "jfaso2_141323s";
        String idCard = "44923319700101395x";

        System.out.println(phoneNumber.matches("1[3-9][\\d]{9}"));
        System.out.println(phone.matches("0\\d{2,3}-?[1-9]\\d{4,9}"));
        System.out.println(email.matches("\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}"));
        System.out.println(username.matches("\\w{4,16}"));
        System.out.println(idCard.matches("[1-9]\\d{5}(18|19|20)\\d{2}((0\\d)|(1[1-2]))(([0-2]\\d)|(3[0-1]))\\d{3}(\\d|(?i)X)"));

        String text = "近日，复旦大学管理学院官网发布《2024年度复旦大学管理学院推免招生不诚信名单通告》。通告称，根据预录取学生与学院签署的承诺书中的相关规定，已对该院2024年度推免招生选拔工作中部分单方面违背承诺书相关条款的学生作出了不同程度的处理。通告还直接公布了相关学生的本科院校、专业和姓名。这引发公众对学生诚信教育和推免招生流程的反思。\n" +
                "推免招生通常指推荐优秀应届本科毕业生免试攻读硕士学位研究生，这是各高校选拔优秀人才的重要途径。从复旦大学管理学院公布的违约名单中可以看出，涉事学生来自国内多所著名高校且专业背景各异，却在推免选拔的关键时刻违背了承诺。这种失信行为可能直接浪费了推免招生的名额，不仅损害了其他申请人的利益，还破坏了推免招生秩序。复旦大学管理学院直接“晒”出失信学生名单，可以说是对当下推免招生中任性违约问题一次毫不留情地披露。\n" +
                "这些学生为何会出尔反尔呢？这背后，既有升学规划的不确定性，也有对个人既有利益的过分追求。现实中，推免招生的具体时间、程序往往由各高校自主确定，获得推免资格的学生可以根据自己的情况灵活申请多所意向学校。这种双向互选的推免招生制度，可以说维护了学生自主选择志愿的权利。但值得注意的是，在手握多所学校的录取意向通知书时，推免生应该本着诚实守信的态度仔细思考、慎重抉择。一旦确定选择某所高校，就要为自己的行为负起责任。现实中，个别学生之所以会发生严重的违约行为，大多是从个人利益最大化的角度出发，签订协议后还“抱着上家找下家”，对校方隐瞒个人的真实情况，没有考虑到失信违约的后果。\n" +
                "也许有人会说，如果多所高校先后发出录取意向或者有更好的就业机会，个人从中择优不得已违约也可以理解。其实不然，就拿复旦大学管理学院的推免招生过程来说，有知情网友反映，从发放通知到正式待录取，学校会多次发邮件与学生进行意向确认，然后签订相关承诺书。也就是说，学校在最终确定正式录取前，已经给了学生充分的考虑时间。如果最后对学校突然爽约，很大程度上会让学校错过补录时机，造成名额的直接浪费，损害其他申请人的利益。\n" +
                "无论是保研还是找工作，遇到取舍问题在所难免，诚信以待、善意沟通是对彼此应有的尊重。一旦签订协议或合同，就要为自己的行为负责。如果每个人或单位都狭隘地从个体利益最大化出发，任性践踏规则，原本有序的流程就会被打乱，公平公正的原则也会受到挑战。面对推免生不诚信的现象，不能仅仅停留在对个案的谴责上，还应深刻反思如何加强诚信教育，建立更加完善的诚信评价体系，以此激励学生自觉遵守诚信原则。\n" +
                "此外，推免生违约现象不止一次地发生也提醒我们反思，推免招生流程是否可以进一步完善，尽量降低学生面对多个心仪学校“撞车”而违约的可能性。比如，一些网友反映，为了能够尽早锁定优秀生源，各学校的招录往往会有时间差，有的甚至在暑期提前启动“保研夏令营”，这导致了一些学生会提前锁定一个保底学校。针对这种现实问题，不妨考虑从顶层设计上完善更加公开透明、双向选择的招选制度，构建及时有效的信息反馈机制。同时，各省级教育行政部门、教育招生考试管理机构要监督高校用好教育部“推免服务系统”，切实遵守推免政策，规范推免程序，做好推免信息公开工作。如此，以更优化的制度为诚信建设保驾护航。";

        Pattern pattern = Pattern.compile("学生");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }

        String str1 = "a123a";
        String str2 = "b456b";
        String str3 = "abc123abc";
        String str4 = "123789123";
        String str5 = "aaa123aaa";
        String str6 = "bbb456bbb";

        String regex1 = "(.).+\\1";
        System.out.println(str1.matches(regex1));
        System.out.println(str2.matches(regex1));

        String regex2 = "(.+).+\\1";
        System.out.println(str3.matches(regex2));
        System.out.println(str4.matches(regex2));

        String regex3 = "((.)\\2*).+\\1";
        System.out.println(str5.matches(regex3));
        System.out.println(str6.matches(regex3));

        String str7 = "我要学学编编编程程程";
        System.out.println(str7.replaceAll("(.)\\1+", "$1"));
    }
}
