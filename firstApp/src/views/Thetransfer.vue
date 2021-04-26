<template>
    <div class="login-container">
        <el-form :model="ruleForm2" :rules="rules2"
         status-icon
         ref="ruleForm2" 
         label-position="left" 
         label-width="0px" 
         class="demo-ruleForm login-page">
            <h3 class="title">转账</h3>
            <el-form-item prop="otherphonenum">
                <el-input type="text" 
                    v-model="ruleForm2.otherphonenum" 
                    auto-complete="off" 
                    placeholder="对方账号"
                ></el-input>
            </el-form-item>

            <el-form-item prop="othername">
                <el-input type="text" 
                    v-model="ruleForm2.othername" 
                    auto-complete="off" 
                    placeholder="对方姓名"
                ></el-input>
            </el-form-item>

            <el-form-item prop="money">
                <el-input type="text" 
                    v-model="ruleForm2.money" 
                    auto-complete="off" 
                    placeholder="转账金额"
                ></el-input>
            </el-form-item>

            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">确认转账</el-button>
            </el-form-item>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="detailedSubmit" :loading="logining">查看流水</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data(){
        return {
            logining: false,
            ruleForm2: {
                otherphonenum: '13107658650',
                othername: '张三',
                money: '400',
            },
            rules2: {
                username: [{required: true, message: 'please enter your account', trigger: 'blur'}],
                password: [{required: true, message: 'enter your password', trigger: 'blur'}]
            },
            checked: false
        }
    },
    methods: {

        detailedSubmit(){

            this.$router.push({path: '/detailed'});
            this.$axios.get(this.GLOBAL.host+'/record').then(res =>{
                        var result = res.data;

                        sessionStorage.setItem("record",JSON.stringify(result))
 
                        // var info=JSON.parse(sessionStorage.getItem("record"))

                        console.log(result);

                        // console.log(info);
                    });
        },

        handleSubmit(event){
            this.$refs.ruleForm2.validate((valid) => {
                if(valid){
                    this.logining = true;
                    var data = {'myPhoneNum':sessionStorage.getItem('user'),'otherPhoneNum':this.ruleForm2.otherphonenum, 'otherName':this.ruleForm2.othername, 'money':this.ruleForm2.money}  
                    this.$axios.post(this.GLOBAL.host+'/record/transfer',data).then(res =>{
                        var result = res.data;
                        if(result == '转账成功'){
                            this.logining = false;
                            this.$alert('转账成功！', 'info', {
                                confirmButtonText: 'ok'
                            })
                        }else{
                            this.logining = false;
                            this.$alert('用户不存在or金额不足!', 'info', {
                                confirmButtonText: 'ok'
                            })
                        }
                    });
                    
                }else{
                    console.log('error submit!');
                    return false;
                }
            })
        }
    }
};
</script>


<style scoped>
.login-container {
    width: 100%;
    height: 100%;
}
.login-page {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
}
label.el-checkbox.rememberme {
    margin: 0px 0px 15px;
    text-align: left;
}
</style>