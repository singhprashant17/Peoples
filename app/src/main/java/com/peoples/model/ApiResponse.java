package com.peoples.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

    /**
     * results : [{"gender":"female","name":{"title":"ms","first":"esma","last":"durmaz"},"location":{"street":"6235 istiklal cd",
     * "city":"balıkesir","state":"şırnak","postcode":14207,"coordinates":{"latitude":"72.9301","longitude":"99.0467"},
     * "timezone":{"offset":"-2:00","description":"Mid-Atlantic"}},"email":"esma.durmaz@example.com",
     * "login":{"uuid":"54e6971e-0998-4df4-8ff2-16b59675b418","username":"blackbutterfly482","password":"wrinkle1","salt":"LKI27rU8",
     * "md5":"5dcb0fa653d05c094e6accd961982a47","sha1":"fdab0ed1f074da0735f2786b399dbca90374c051",
     * "sha256":"18e0722c51201bd1872abf7c0f5481b780d940cbd596002e727e35dd91682ce5"},"dob":{"date":"1981-03-02T14:07:13Z","age":37},
     * "registered":{"date":"2007-06-26T12:35:26Z","age":11},"phone":"(443)-721-5038","cell":"(260)-047-6991","id":{"name":"","value":null},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/54.jpg","medium":"https://randomuser.me/api/portraits/med/women/54.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/54.jpg"},"nat":"TR"},{"gender":"female","name":{"title":"mrs","first":"paula",
     * "last":"gimenez"},"location":{"street":"2769 avenida de américa","city":"santiago de compostela","state":"país vasco","postcode":41665,
     * "coordinates":{"latitude":"-87.9734","longitude":"-50.4641"},"timezone":{"offset":"+7:00","description":"Bangkok, Hanoi, Jakarta"}},
     * "email":"paula.gimenez@example.com","login":{"uuid":"e49117ba-ee26-4bc5-9d40-ce53fa756e64","username":"purplezebra205","password":"dookie",
     * "salt":"m7PBwy4A","md5":"6b5dc10e4a43848e1da8700a45e8f949","sha1":"4db213c69c135395a7f8f3fd364a43816e118905",
     * "sha256":"a491d051500b941c501e552dee3414536a7703159e478534ca9ba5aad069ee98"},"dob":{"date":"1948-06-21T15:39:25Z","age":70},
     * "registered":{"date":"2005-12-14T19:23:57Z","age":12},"phone":"955-528-942","cell":"614-414-971","id":{"name":"DNI","value":"54799145-E"},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/49.jpg","medium":"https://randomuser.me/api/portraits/med/women/49.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/49.jpg"},"nat":"ES"},{"gender":"female","name":{"title":"miss",
     * "first":"رونیکا","last":"محمدخان"},"location":{"street":"1751 کمیل","city":"بابل","state":"کرمان","postcode":43690,
     * "coordinates":{"latitude":"21.5766","longitude":"178.0132"},"timezone":{"offset":"+5:45","description":"Kathmandu"}},"email":"رونیکا
     * .محمدخان@example.com","login":{"uuid":"11388983-de63-4277-a6eb-297bef1692ab","username":"browntiger242","password":"faster",
     * "salt":"s3gISudO","md5":"4105100d87e5ae4a3ca183b875716590","sha1":"721835e926d9f8e98b280bd505f03f18fc25888e",
     * "sha256":"547311ef5556515e567ec18b6a42b37468455d6e4e3a6df794163553807e1fae"},"dob":{"date":"1989-10-18T05:45:09Z","age":28},
     * "registered":{"date":"2011-07-20T20:20:43Z","age":7},"phone":"023-82672998","cell":"0978-970-3923","id":{"name":"","value":null},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/67.jpg","medium":"https://randomuser.me/api/portraits/med/women/67.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/67.jpg"},"nat":"IR"},{"gender":"female","name":{"title":"madame",
     * "first":"susanne","last":"caron"},"location":{"street":"4812 rue jean-baldassini","city":"gerzensee","state":"solothurn","postcode":9530,
     * "coordinates":{"latitude":"-16.1853","longitude":"33.2306"},"timezone":{"offset":"+10:00","description":"Eastern Australia, Guam,
     * Vladivostok"}},"email":"susanne.caron@example.com","login":{"uuid":"4b2f2d54-d18b-450a-93e2-d9b34d3bb3fe","username":"ticklishfrog605",
     * "password":"valhalla","salt":"c21rIlOc","md5":"9cf48ceed11613f120db6a6273386830","sha1":"c22901a0aa53ce0aef5700b144310220363a160b",
     * "sha256":"d4a05f7b8cff8676d219ce19e4b9b3f778cac1149937358533749f45f9f68519"},"dob":{"date":"1991-02-22T20:54:50Z","age":27},
     * "registered":{"date":"2013-08-03T00:47:07Z","age":5},"phone":"(865)-100-4852","cell":"(922)-221-8998","id":{"name":"AVS",
     * "value":"756.2092.9357.21"},"picture":{"large":"https://randomuser.me/api/portraits/women/67.jpg","medium":"https://randomuser
     * .me/api/portraits/med/women/67.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/67.jpg"},"nat":"CH"},{"gender":"female",
     * "name":{"title":"ms","first":"ludmilla","last":"lüders"},"location":{"street":"römerstraße 65","city":"wernigerode",
     * "state":"baden-württemberg","postcode":22359,"coordinates":{"latitude":"55.9067","longitude":"98.7413"},"timezone":{"offset":"-6:00",
     * "description":"Central Time (US & Canada), Mexico City"}},"email":"ludmilla.lüders@example.com",
     * "login":{"uuid":"deb05f35-3be2-4bf7-a5a9-0dd482a0ed58","username":"orangecat409","password":"shaolin","salt":"twfrWHak",
     * "md5":"34fa1d415baa95fd9709ea96cccb951a","sha1":"471b49e46a9fb2f1bff5baa004d74eb9097eaa82",
     * "sha256":"93fb7cbfa659a1d7a996240cc7cba1c4cc533d7bb9153101b366149b64eab536"},"dob":{"date":"1954-05-22T03:41:44Z","age":64},
     * "registered":{"date":"2006-12-02T15:49:45Z","age":11},"phone":"0658-0622215","cell":"0171-5556017","id":{"name":"","value":null},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/38.jpg","medium":"https://randomuser.me/api/portraits/med/women/38.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/38.jpg"},"nat":"DE"},{"gender":"female","name":{"title":"mrs",
     * "first":"angeles","last":"soler"},"location":{"street":"1991 calle de arturo soria","city":"ferrol","state":"asturias","postcode":39957,
     * "coordinates":{"latitude":"68.4328","longitude":"72.0083"},"timezone":{"offset":"-8:00","description":"Pacific Time (US & Canada)"}},
     * "email":"angeles.soler@example.com","login":{"uuid":"bcfdb811-17e8-43e4-8332-defe40f3f58b","username":"orangecat285","password":"kungfu",
     * "salt":"EiQw8A6W","md5":"de0f83ed0014bd3757f7dfe43e7df6d4","sha1":"f493b62c42b0dea32adb21cd2d3d08eb7eef1aae",
     * "sha256":"79b4b88b56a95a699165e487fc8d59abb6cbc81e952e84f4a71d95c8ff39e36a"},"dob":{"date":"1973-11-05T07:05:25Z","age":44},
     * "registered":{"date":"2016-09-13T03:11:39Z","age":2},"phone":"901-499-991","cell":"620-374-517","id":{"name":"DNI","value":"33049753-I"},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/20.jpg","medium":"https://randomuser.me/api/portraits/med/women/20.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/20.jpg"},"nat":"ES"},{"gender":"female","name":{"title":"ms","first":"zara",
     * "last":"patel"},"location":{"street":"8125 kamo road","city":"timaru","state":"marlborough","postcode":34422,
     * "coordinates":{"latitude":"-41.8630","longitude":"-131.8966"},"timezone":{"offset":"0:00","description":"Western Europe Time, London,
     * Lisbon, Casablanca"}},"email":"zara.patel@example.com","login":{"uuid":"3da8c39d-f025-4514-8802-c825246a9d0a","username":"happygorilla934",
     * "password":"4711","salt":"AEOX1evy","md5":"28c84730387bd3d5033ef51f144ce2f2","sha1":"71e6b388af97ee56d7db4e220c6c3c63f0b42f99",
     * "sha256":"0dd3478f3eb7ea9b3fd16ec65b1f4b4991f225f0b8f3f5c9eebbc7275d677f33"},"dob":{"date":"1964-04-02T20:33:00Z","age":54},
     * "registered":{"date":"2018-04-23T16:51:32Z","age":0},"phone":"(676)-687-2667","cell":"(612)-560-7301","id":{"name":"","value":null},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/53.jpg","medium":"https://randomuser.me/api/portraits/med/women/53.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/53.jpg"},"nat":"NZ"},{"gender":"male","name":{"title":"mr","first":"james",
     * "last":"butler"},"location":{"street":"1574 new road","city":"stirling","state":"county fermanagh","postcode":"C05 6BF",
     * "coordinates":{"latitude":"-48.0960","longitude":"-79.6123"},"timezone":{"offset":"0:00","description":"Western Europe Time, London, Lisbon,
     * Casablanca"}},"email":"james.butler@example.com","login":{"uuid":"3292988a-01c5-46b1-a923-642572a5f6ec","username":"orangeladybug681",
     * "password":"navajo","salt":"WhPQV69P","md5":"c2994cf50c0bfbef8e4186124cee7de6","sha1":"b67d3c8a6db1dedf1a893be9c05dd50ec16decb7",
     * "sha256":"5346bad7567b66b271953245b253f03c609c06225c705532b41016a0c068c9d4"},"dob":{"date":"1957-11-07T08:09:40Z","age":60},
     * "registered":{"date":"2006-07-02T14:40:59Z","age":12},"phone":"015394 58833","cell":"0764-724-707","id":{"name":"NINO","value":"WM 09 56 90
     * L"},"picture":{"large":"https://randomuser.me/api/portraits/men/86.jpg","medium":"https://randomuser.me/api/portraits/med/men/86.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/men/86.jpg"},"nat":"GB"},{"gender":"female","name":{"title":"mrs","first":"hanny",
     * "last":"lemke"},"location":{"street":"blumenstraße 12","city":"schöppenstedt","state":"rheinland-pfalz","postcode":32844,
     * "coordinates":{"latitude":"4.4650","longitude":"9.8815"},"timezone":{"offset":"+5:00","description":"Ekaterinburg, Islamabad, Karachi,
     * Tashkent"}},"email":"hanny.lemke@example.com","login":{"uuid":"238e3027-fffe-4241-9c79-2b5506fc945d","username":"crazyswan822",
     * "password":"juniper","salt":"ZmojTrOv","md5":"0eea2298cdec623c00c3ba3704574452","sha1":"1c4eba027ca2dd4a3baf1fff74e1e7b81b31d71b",
     * "sha256":"1c6c6ebb066e70c8298cbd46d609cd344c53130afad1253dc584cabfda23e6a1"},"dob":{"date":"1982-12-14T16:37:07Z","age":35},
     * "registered":{"date":"2006-04-02T21:01:33Z","age":12},"phone":"0873-8787820","cell":"0176-9426365","id":{"name":"","value":null},
     * "picture":{"large":"https://randomuser.me/api/portraits/women/44.jpg","medium":"https://randomuser.me/api/portraits/med/women/44.jpg",
     * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/44.jpg"},"nat":"DE"},{"gender":"female","name":{"title":"madame",
     * "first":"stéphanie","last":"gaillard"},"location":{"street":"2880 rue de la mairie","city":"fischbach-göslikon","state":"bern",
     * "postcode":1125,"coordinates":{"latitude":"28.4000","longitude":"174.5773"},"timezone":{"offset":"-11:00","description":"Midway Island,
     * Samoa"}},"email":"stéphanie.gaillard@example.com","login":{"uuid":"8f7d6c64-67ac-4d15-a066-e5f8abaadc39","username":"smallkoala372",
     * "password":"andreas","salt":"oh0kqfFK","md5":"ace07258b3d32fe9342bb49667b823e0","sha1":"e6a8e1be6f43e64d39eb6030945bf9ca8ceadf8d",
     * "sha256":"6a92eba6ef480c95a9949124827520ab0f599960666dd5831e3ed6d434dabb14"},"dob":{"date":"1945-12-15T17:14:25Z","age":72},
     * "registered":{"date":"2006-11-21T01:58:34Z","age":11},"phone":"(775)-578-8437","cell":"(312)-881-5166","id":{"name":"AVS",
     * "value":"756.6212.0425.13"},"picture":{"large":"https://randomuser.me/api/portraits/women/6.jpg","medium":"https://randomuser
     * .me/api/portraits/med/women/6.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/6.jpg"},"nat":"CH"}]
     * info : {"seed":"6c9aefc31440d349","results":10,"page":1,"version":"1.2"}
     */

    @SerializedName("info")
    private Info info;
    @SerializedName("results")
    private List<Results> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Results> getResults() {
        if (results == null) {
            return new ArrayList<>();
        }
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Info {
        /**
         * seed : 6c9aefc31440d349
         * results : 10
         * page : 1
         * version : 1.2
         */

        @SerializedName("seed")
        private String seed;
        @SerializedName("results")
        private int results;
        @SerializedName("page")
        private int page;
        @SerializedName("version")
        private String version;

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

        public int getResults() {
            return results;
        }

        public void setResults(int results) {
            this.results = results;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static class Results {
        /**
         * gender : female
         * name : {"title":"ms","first":"esma","last":"durmaz"}
         * location : {"street":"6235 istiklal cd","city":"balıkesir","state":"şırnak","postcode":14207,"coordinates":{"latitude":"72.9301",
         * "longitude":"99.0467"},"timezone":{"offset":"-2:00","description":"Mid-Atlantic"}}
         * email : esma.durmaz@example.com
         * login : {"uuid":"54e6971e-0998-4df4-8ff2-16b59675b418","username":"blackbutterfly482","password":"wrinkle1","salt":"LKI27rU8",
         * "md5":"5dcb0fa653d05c094e6accd961982a47","sha1":"fdab0ed1f074da0735f2786b399dbca90374c051",
         * "sha256":"18e0722c51201bd1872abf7c0f5481b780d940cbd596002e727e35dd91682ce5"}
         * dob : {"date":"1981-03-02T14:07:13Z","age":37}
         * registered : {"date":"2007-06-26T12:35:26Z","age":11}
         * phone : (443)-721-5038
         * cell : (260)-047-6991
         * id : {"name":"","value":null}
         * picture : {"large":"https://randomuser.me/api/portraits/women/54.jpg","medium":"https://randomuser.me/api/portraits/med/women/54.jpg",
         * "thumbnail":"https://randomuser.me/api/portraits/thumb/women/54.jpg"}
         * nat : TR
         */

        @SerializedName("gender")
        private String gender;
        @SerializedName("name")
        private Name name;
        @SerializedName("location")
        private Location location;
        @SerializedName("email")
        private String email;
        @SerializedName("login")
        private Login login;
        @SerializedName("dob")
        private Dob dob;
        @SerializedName("registered")
        private Registered registered;
        @SerializedName("phone")
        private String phone;
        @SerializedName("cell")
        private String cell;
        @SerializedName("id")
        private Id id;
        @SerializedName("picture")
        private Picture picture;
        @SerializedName("nat")
        private String nat;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Login getLogin() {
            return login;
        }

        public void setLogin(Login login) {
            this.login = login;
        }

        public Dob getDob() {
            return dob;
        }

        public void setDob(Dob dob) {
            this.dob = dob;
        }

        public Registered getRegistered() {
            return registered;
        }

        public void setRegistered(Registered registered) {
            this.registered = registered;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCell() {
            return cell;
        }

        public void setCell(String cell) {
            this.cell = cell;
        }

        public Id getId() {
            return id;
        }

        public void setId(Id id) {
            this.id = id;
        }

        public Picture getPicture() {
            return picture;
        }

        public void setPicture(Picture picture) {
            this.picture = picture;
        }

        public String getNat() {
            return nat;
        }

        public void setNat(String nat) {
            this.nat = nat;
        }

        public static class Name {
            /**
             * title : ms
             * first : esma
             * last : durmaz
             */

            @SerializedName("title")
            private String title;
            @SerializedName("first")
            private String first;
            @SerializedName("last")
            private String last;

            public String getTitle() {
                if (title == null) {
                    title = "";
                }
                return title.trim();
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFirst() {
                if (first == null) {
                    first = "";
                }
                return first.trim();
            }

            public void setFirst(String first) {
                this.first = first;
            }

            public String getLast() {
                if (last == null) {
                    last = "";
                }
                return last;
            }

            public void setLast(String last) {
                this.last = last;
            }

            public String getFullName() {
                return (getTitle() + " " + getFirst() + " " + getLast()).trim();
            }
        }

        public static class Location {
            /**
             * street : 6235 istiklal cd
             * city : balıkesir
             * state : şırnak
             * postcode : 14207
             * coordinates : {"latitude":"72.9301","longitude":"99.0467"}
             * timezone : {"offset":"-2:00","description":"Mid-Atlantic"}
             */

            @SerializedName("street")
            private String street;
            @SerializedName("city")
            private String city;
            @SerializedName("state")
            private String state;
            @SerializedName("postcode")
            private String postcode;
            @SerializedName("coordinates")
            private Coordinates coordinates;
            @SerializedName("timezone")
            private Timezone timezone;

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public Coordinates getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(Coordinates coordinates) {
                this.coordinates = coordinates;
            }

            public Timezone getTimezone() {
                return timezone;
            }

            public void setTimezone(Timezone timezone) {
                this.timezone = timezone;
            }

            public static class Coordinates {
                /**
                 * latitude : 72.9301
                 * longitude : 99.0467
                 */

                @SerializedName("latitude")
                private String latitude;
                @SerializedName("longitude")
                private String longitude;

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }

            public static class Timezone {
                /**
                 * offset : -2:00
                 * description : Mid-Atlantic
                 */

                @SerializedName("offset")
                private String offset;
                @SerializedName("description")
                private String description;

                public String getOffset() {
                    return offset;
                }

                public void setOffset(String offset) {
                    this.offset = offset;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }
        }

        public static class Login {
            /**
             * uuid : 54e6971e-0998-4df4-8ff2-16b59675b418
             * username : blackbutterfly482
             * password : wrinkle1
             * salt : LKI27rU8
             * md5 : 5dcb0fa653d05c094e6accd961982a47
             * sha1 : fdab0ed1f074da0735f2786b399dbca90374c051
             * sha256 : 18e0722c51201bd1872abf7c0f5481b780d940cbd596002e727e35dd91682ce5
             */

            @SerializedName("uuid")
            private String uuid;
            @SerializedName("username")
            private String username;
            @SerializedName("password")
            private String password;
            @SerializedName("salt")
            private String salt;
            @SerializedName("md5")
            private String md5;
            @SerializedName("sha1")
            private String sha1;
            @SerializedName("sha256")
            private String sha256;

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getSalt() {
                return salt;
            }

            public void setSalt(String salt) {
                this.salt = salt;
            }

            public String getMd5() {
                return md5;
            }

            public void setMd5(String md5) {
                this.md5 = md5;
            }

            public String getSha1() {
                return sha1;
            }

            public void setSha1(String sha1) {
                this.sha1 = sha1;
            }

            public String getSha256() {
                return sha256;
            }

            public void setSha256(String sha256) {
                this.sha256 = sha256;
            }
        }

        public static class Dob {
            /**
             * date : 1981-03-02T14:07:13Z
             * age : 37
             */

            @SerializedName("date")
            private String date;
            @SerializedName("age")
            private int age;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        public static class Registered {
            /**
             * date : 2007-06-26T12:35:26Z
             * age : 11
             */

            @SerializedName("date")
            private String date;
            @SerializedName("age")
            private int age;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        public static class Id {
            /**
             * name :
             * value : null
             */

            @SerializedName("name")
            private String name;
            @SerializedName("value")
            private Object value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getValue() {
                return value;
            }

            public void setValue(Object value) {
                this.value = value;
            }
        }

        public static class Picture {
            /**
             * large : https://randomuser.me/api/portraits/women/54.jpg
             * medium : https://randomuser.me/api/portraits/med/women/54.jpg
             * thumbnail : https://randomuser.me/api/portraits/thumb/women/54.jpg
             */

            @SerializedName("large")
            private String large;
            @SerializedName("medium")
            private String medium;
            @SerializedName("thumbnail")
            private String thumbnail;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }
        }
    }
}
