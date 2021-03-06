// install plugin
Vue.use(VueI18n)

const i18n = new VueI18n({
	   locale: global_i18n_locale,
	   messages: {
	     cn:  jQuery.extend(global_i18n_cn , {
		       welcome: '欢迎登录',
		       title:'CRM--前台',
		       languageSelect:'语音选择',
		       login:'登录',
		       account:'账号',
		       password:'密码',
		       captcha:'验证码',
		       refresh:'点击刷新',
		       modifyPwd:'修改密码',
		       logout:'退出系统',
		       navMenu:'导航菜单',
		       mainPage:'首页',
		       console:'控制台',
		       oldPwd:'旧密码',
		       newPwd:'新密码',
		       differentPwd:'两个新密码不一致',		       
		       retypePwd:'确认新密码'
		     }),	     
		  en:  jQuery.extend(global_i18n_en , {
		       welcome: 'Welcome',
		       title:'CRM SITE',
		       languageSelect:'Language',
		       login:'Log In',
		       account:'Account',
		       password:'password',
		       captcha:'captcha',		       
		       refresh:'Refresh',
		       modifyPwd:'Change Password',
		       logout:'Logout',
		       navMenu:'Navigation',
		       mainPage:'MainPage',
		       console:'Console',	
		       oldPwd:'Old Passowrd',
		       newPwd:'New Passowrd',
		       differentPwd:'two new password are different',		       
		       retypePwd:'Retype New'		    	   
	         })
	   }
})

