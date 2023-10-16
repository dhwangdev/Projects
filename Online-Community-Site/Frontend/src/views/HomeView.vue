<template>
  <div class="home">

    <body>
      <!-- 배경화면 -->
      <div>
        <b-carousel id="carousel-1" :interval="3500">
          <b-carousel-slide>
            <template #img>
              <img class="home-pic" src="../assets/home/homeImg1.jpg" alt="image slot" />
            </template>
          </b-carousel-slide>
          <b-carousel-slide>
            <template #img>
              <img class="home-pic" src="../assets/home/homeImg2.jpg" alt="image slot" />
            </template>
          </b-carousel-slide>
          <b-carousel-slide>
            <template #img>
              <img class="home-pic" src="../assets/home/homeImg3.jpg" alt="image slot" />
            </template>
          </b-carousel-slide>
          <b-carousel-slide>
            <template #img>
              <img class="home-pic" src="../assets/home/homeImg4.jpg" alt="image slot" />
            </template>
          </b-carousel-slide>
        </b-carousel>
      </div>

      <!-- 로그인창 -->
      <div class="login">
        <h1>로그인</h1>
        <div class="book_now">
          <div>
            <span>아이디</span>
            <input class="login_input" placeholder="아이디" type="text" v-model="userId" />
          </div>
          <div>
            <span>비밀번호</span>
            <input class="login_input" placeholder="비밀번호" type="password" v-model="password" />
          </div>
          <div>
            <button class="login_btn" @click="login">Sign in</button>
          </div>
          <div>
            <!-- <b-button class="signup_btn" v-b-modal.modal-1 @click="init">회원가입</b-button> -->
            <b-button id="show-btn" class="signup_btn" @click="[$bvModal.show('bv-modal-example'), init()]">회원가입
            </b-button>
          </div>
        </div>
      </div>
    </body>

    <!-- 회원가입 폼 -->
    <div>
      <b-modal id="bv-modal-example" hide-footer>
        <template #modal-title>
          <code>회원가입</code>
        </template>
        <div class="d-block text-center">
          <div class="container">
            <div for="id"><b>ID</b></div>
            <b-input-group>
              <b-form-input type="text" placeholder="아이디" v-model="registId"></b-form-input>
              <b-input-group-append>
                <b-button @click="overlapCheckID">중복확인</b-button>
              </b-input-group-append>
            </b-input-group><br />

            <div for="psw"><b>비밀번호</b></div>
            <b-input-group>
              <b-form-input type="password" placeholder="비밀번호" v-model="registPassword">
              </b-form-input>
            </b-input-group><br />
            <div for="id"><b>닉네임</b></div>
            <b-input-group>
              <b-form-input type="text" placeholder="닉네임" v-model="registNickname"></b-form-input>
              <b-input-group-append>
                <b-button @click="overlapCheckName">중복확인</b-button>
              </b-input-group-append>
            </b-input-group><br />

            <div for="email"><b>Email</b></div>
            <b-input-group>
              <b-form-input type="text" placeholder="이메일 주소" v-model="reigstEmail"></b-form-input>
              <b-input-group-append>
                <b-button @click="overlapCheckEmail">중복확인</b-button>
              </b-input-group-append>
            </b-input-group><br />

            <button @click="registUser" v-bind:class="[checkTotal ? 'enable' : 'disable']">회원가입</button>
          </div>
        </div>
        <b-button class="close" block @click="$bvModal.hide('bv-modal-example')">닫기</b-button>
      </b-modal>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  computed: {
    ...mapState([
      'nickname',
      'checkId',
      'checkNickname',
      'checkEmail',
    ]),


  },
  data() {
    return {
      userId: "",
      password: "",
      registId: "",
      registPassword: "",
      registNickname: "",
      reigstEmail: "",
      checkTotal: false,
      idCheck: false,
      nameCheck: false,
      EmailCheck: false,

    }
  },
  watch: {
    checkId(val) {
      this.idCheck = val;
      if (this.idCheck && this.nameCheck && this.EmailCheck) {
        this.checkTotal = true;
      }
      else {
        this.checkTotal = false;
      }
    },
    checkNickname(val) {
      this.nameCheck = val;
      if (this.idCheck && this.nameCheck && this.EmailCheck) {
        this.checkTotal = true;
      }
      else {
        this.checkTotal = false;
      }

    },
    checkEmail(val) {
      this.EmailCheck = val;
      if (this.idCheck && this.nameCheck && this.EmailCheck) {
        this.checkTotal = true;
      }
      else {
        this.checkTotal = false;
      }
    },
  },
  methods: {
    init() {
      this.checkTotal = false;
      this.$store.dispatch('checkInit');
    },
    registUser() {
      if (this.registPassword.length <= 0) {
        alert("비밀번호를 입력하세요.")
      }
      else {
        let user = { userId: "", password: "", email: "", nickname: "", image: "", joindate: "" };
        user.userId = this.registId;
        user.password = this.registPassword;
        user.email = this.reigstEmail;
        user.nickname = this.registNickname;
        let today = new Date();
        let year = today.getFullYear();
        let month = ('0' + (today.getMonth() + 1)).slice(-2);
        let day = ('0' + today.getDate()).slice(-2);
        user.joindate = year + '-' + month + '-' + day;

        this.$store.dispatch('registUser', { user: user });
        document.querySelector(".close").click();
      }
    },
    login() {
      let user = { userId: "", password: "", email: "", nickname: "", image: "", joindate: "" };
      user.userId = this.userId;
      user.password = this.password;

      this.$store.dispatch('userLogin', { user: user });
    },
    overlapCheckID() {
      this.$store.dispatch('overlapCheck', { type: 'id', val: this.registId });
    },
    overlapCheckName() {
      this.$store.dispatch('overlapCheck', { type: 'nickname', val: this.registNickname });

    },
    overlapCheckEmail() {
      this.$store.dispatch('overlapCheck', { type: 'email', val: this.reigstEmail });
    }
  }
};
</script>

<style scoped>
.home-pic {
  width: 100vw;
  height: 100vh;
}

.login {
  position: absolute;
  width: 30%;
  top: 50%;
  transform: translateY(-50%);
  padding: 30px 35px;
  border-left: red solid 5px;
  background-color: rgba(7, 6, 6, 0.65);
  border-radius: 3%;
  margin-left: 5px;
}

.login h1 {
  font-weight: 500;
  font-size: 30px;
  line-height: 30px;
  color: white;
  padding-bottom: 20px;
  text-transform: uppercase;
  text-align: center;
}

.login span {
  display: block;
  color: white;
  font-size: 18px;
  padding-bottom: 5px;
}

.login .login_input {
  width: 100%;
  height: 50px;
  border: white solid 1px;
  /* background-color: transparent; */
  color: black;
  padding: 0 10px;
  padding-right: 61px;
  margin-bottom: 25px;
  position: relative;
}

.login_btn {
  background-color: red;
  max-width: 189px;
  width: 100%;
  margin: 0 auto;
  padding: 10px 0;
  border-radius: 50px;
  color: white;
  font-size: 20px;
  transition: ease-in 0.5s;
  border: 0;
  margin-bottom: 5px;
  display: block;
}

.login_btn:hover {
  background-color: #fff;
  color: red;
  transition: ease-in 0.5s;
}

.signup_btn {
  background-color: red;
  max-width: 189px;
  width: 100%;
  margin: 0 auto;
  padding: 10px 0;
  border-radius: 50px;
  color: white;
  font-size: 20px;
  transition: ease-in 0.5s;
  display: block;
}

.signup_btn:hover {
  background-color: #fff;
  color: red;
  transition: ease-in 0.5s;
}

.container {
  padding: 16px;
}

input[type="text"],
input[type="password"] {
  width: 50%;
  padding: 15px;
  height: 43px;
  display: inline-block;
  border: none;
  background: white;
  border: 2px solid black;
}

input[type="text"]:focus,
input[type="password"]:focus {
  background-color: white;
  outline: none;
}

.enable {
  background-color: lightblue;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.disable {
  background-color: white;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  width: 100%;
  opacity: 0.9;
  visibility: hidden;

}

.container>div {
  text-align: left;
}

.close {
  visibility: hidden;
}

.registerbtn:hover {
  opacity: 3;
}

a {
  color: dodgerblue;
}

code {
  font-weight: bold;
  font-size: 110%;
}
</style>
