package com.stear.bean;

import java.io.Serializable;

/**
 * 百度贴吧的楼层为Json格式，此类便于使用Gson解析
 */
public class BaiduPostBarJson {


    /*
     * author : {"user_id":4142113238,"user_name":"南雁minami","props":null,"portrait":"tb.1.480fae62.pgRHDlOkFdO84ZPNGAJoTw?t=1564498522","user_nickname":null}
     * content : {"post_id":134150967302,"is_anonym":false,"forum_id":12263672,"thread_id":6886125851,"content":"简介：<br>本篇同人将把苍蔷薇一行全部葬送掉哦。<br>虽然这样说搞得好像我很讨厌她们似的，但是没有，没有哦，我还挺喜欢她们的。<br>我只是认同他们在正传中肯定被灭的推论，并在符合剧情逻辑的情况下，试着自行给出她们的结局～<br>时间线在第14卷和第15卷之间，王国刚刚毁灭的半个月之内，可以视为第十四卷的\u201c后日谈\u201d。<br>主要看点有四个：<br>一：拉娜在大坟墓的遭遇。<br>二：鲜血帝前来谒见，并与拉娜同桌吃饭。<br>三：苍蔷薇的破灭。（苍蔷薇VS格兰特）<br>四：朱红露滴的破灭。（阿滋斯+莉古李特VS安滋）<br>篇幅大约五至七万字，将有七个章节：<br>「00、未来的末路」<br>「01、魔女的出卖」<br>「02、破灭的序幕」<br>「03、虫蛀的蔷薇」<br>「04、皇帝的忧郁」<br>「05、朱红的血露」<br>「06、尾声」<br>偏重文戏。<br>部分可能会刺激到度娘的词语，将采取通假处理。<br><img class=\"BDE_Image\" pic_type=\"0\" width=\"560\" height=\"465\" src=\"http://tiebapic.baidu.com/forum/w%3D580/sign=5f244a3618b30f24359aec0bf894d192/311dcbcf3bc79f3ddc710567ada1cd11738b29f2.jpg\" size=\"748103\" >","post_no":1,"type":"0","comment_num":0,"is_fold":0,"props":null,"post_index":0,"pb_tpoint":null}
     */

    private AuthorDTO author;
    private ContentDTO content;

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public ContentDTO getContent() {
        return content;
    }

    public void setContent(ContentDTO content) {
        this.content = content;
    }

    public static class AuthorDTO implements Serializable {
        /*
         * user_id : 4142113238
         * user_name : 南雁minami
         * props : null
         * portrait : tb.1.480fae62.pgRHDlOkFdO84ZPNGAJoTw?t=1564498522
         * user_nickname : null
         */

        private long user_id;
        private String user_name;
        private Object props;
        private String portrait;
        private Object user_nickname;

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public Object getProps() {
            return props;
        }

        public void setProps(Object props) {
            this.props = props;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public Object getUser_nickname() {
            return user_nickname;
        }

        public void setUser_nickname(Object user_nickname) {
            this.user_nickname = user_nickname;
        }
    }

    public static class ContentDTO implements Serializable {
        /*
         * post_id : 134150967302
         * is_anonym : false
         * forum_id : 12263672
         * thread_id : 6886125851
         * content : 简介：<br>本篇同人将把苍蔷薇一行全部葬送掉哦。<br>虽然这样说搞得好像我很讨厌她们似的，但是没有，没有哦，我还挺喜欢她们的。<br>我只是认同他们在正传中肯定被灭的推论，并在符合剧情逻辑的情况下，试着自行给出她们的结局～<br>时间线在第14卷和第15卷之间，王国刚刚毁灭的半个月之内，可以视为第十四卷的“后日谈”。<br>主要看点有四个：<br>一：拉娜在大坟墓的遭遇。<br>二：鲜血帝前来谒见，并与拉娜同桌吃饭。<br>三：苍蔷薇的破灭。（苍蔷薇VS格兰特）<br>四：朱红露滴的破灭。（阿滋斯+莉古李特VS安滋）<br>篇幅大约五至七万字，将有七个章节：<br>「00、未来的末路」<br>「01、魔女的出卖」<br>「02、破灭的序幕」<br>「03、虫蛀的蔷薇」<br>「04、皇帝的忧郁」<br>「05、朱红的血露」<br>「06、尾声」<br>偏重文戏。<br>部分可能会刺激到度娘的词语，将采取通假处理。<br><img class="BDE_Image" pic_type="0" width="560" height="465" src="http://tiebapic.baidu.com/forum/w%3D580/sign=5f244a3618b30f24359aec0bf894d192/311dcbcf3bc79f3ddc710567ada1cd11738b29f2.jpg" size="748103" >
         * post_no : 1
         * type : 0
         * comment_num : 0
         * is_fold : 0
         * props : null
         * post_index : 0
         * pb_tpoint : null
         */

        private long post_id;
        private boolean is_anonym;
        private int forum_id;
        private long thread_id;
        private String content;
        private int post_no;
        private String type;
        private int comment_num;
        private int is_fold;
        private Object props;
        private int post_index;
        private Object pb_tpoint;

        public long getPost_id() {
            return post_id;
        }

        public void setPost_id(long post_id) {
            this.post_id = post_id;
        }

        public boolean isIs_anonym() {
            return is_anonym;
        }

        public void setIs_anonym(boolean is_anonym) {
            this.is_anonym = is_anonym;
        }

        public int getForum_id() {
            return forum_id;
        }

        public void setForum_id(int forum_id) {
            this.forum_id = forum_id;
        }

        public long getThread_id() {
            return thread_id;
        }

        public void setThread_id(long thread_id) {
            this.thread_id = thread_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getPost_no() {
            return post_no;
        }

        public void setPost_no(int post_no) {
            this.post_no = post_no;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public int getIs_fold() {
            return is_fold;
        }

        public void setIs_fold(int is_fold) {
            this.is_fold = is_fold;
        }

        public Object getProps() {
            return props;
        }

        public void setProps(Object props) {
            this.props = props;
        }

        public int getPost_index() {
            return post_index;
        }

        public void setPost_index(int post_index) {
            this.post_index = post_index;
        }

        public Object getPb_tpoint() {
            return pb_tpoint;
        }

        public void setPb_tpoint(Object pb_tpoint) {
            this.pb_tpoint = pb_tpoint;
        }
    }
}

