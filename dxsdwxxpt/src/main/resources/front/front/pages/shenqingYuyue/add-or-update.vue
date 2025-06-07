<template>
    <view class="content">
        <form class="app-update-pv">
                <!--<view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">用户</view>
                    <picker @change="yonghuChange" :value="yonghuIndex" :range="yonghuOptions" range-key="yonghuName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.yonghuId?ruleForm.yonghuName:"请选择用户"}}</view>
                    </picker>
                </view>-->
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">报名编号</view>
                <input   disabled
                         :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.shenqingYuyueUuidNumber" type="text" v-model="ruleForm.shenqingYuyueUuidNumber" placeholder="报名编号"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">申请理由</view>
                <textarea :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.shenqingYuyueText" v-model="ruleForm.shenqingYuyueText" placeholder="申请理由"/>
            </view>
                <view
                        :style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(218, 220, 219, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"108rpx"}'
                        class="cu-form-group" @tap="shenqingYuyueFileTap">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">上传图片</view>
                    <view class="right-input" style="padding:0;textAlign:left">
                        <image
                                :style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
                                class="avator" v-if="ruleForm.shenqingYuyueFile" :src="baseUrl+ruleForm.shenqingYuyueFile" mode="aspectFill">
                        </image>
                        <image  :style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
                                class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
                    </view>
                </view>
					                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                          class="title">申请状态</view>
                    <picker @change="shenqingYuyueTypesChange" :value="shenqingYuyueTypesIndex" :range="shenqingYuyueTypesOptions" range-key="indexName">
                        <view
                                :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.shenqingYuyueTypes?ruleForm.shenqingYuyueValue:"请选择申请状态"}}</view>
                    </picker>
                </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
                      class="title">预约时间</view>
                <input
                        :style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                        v-model="ruleForm.shenqingYuyueTime" placeholder="预约时间" :readonly="ro.shenqingYuyueTime"
                        @tap="toggleTab('shenqingYuyueTime')"></input>
            </view>

            <view class="btn">
                <button
                        :style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"var(--publicMainColor)","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
                        @tap="onSubmitTap" class="bg-red">提交</button>
            </view>
        </form>

					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
                              ref="insertTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="shenqingYuyueShenheTimeConfirm"
                              ref="shenqingYuyueShenheTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="shenqingYuyueTimeConfirm"
                              ref="shenqingYuyueTime" themeColor="#333333"></w-picker>
					<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
                              ref="createTime" themeColor="#333333"></w-picker>


    </view>
</template>

<script>
    import wPicker from "@/components/w-picker/w-picker.vue";

    export default {
        data() {
            return {
                cross: '',
                ro:{
					shenqingYuyueUuidNumber: true,
					yonghuId: false,
					shenqingYuyueText: false,
					shenqingYuyueFile: false,
					insertTime: false,
					shenqingYuyueYesnoTypes: false,
					shenqingYuyueTypes: false,
					shenqingYuyueYesnoText: false,
					shenqingYuyueShenheTime: false,
					shenqingYuyueTime: false,
					createTime: false,
        },
            ruleForm: {
					shenqingYuyueUuidNumber: this.getUUID(),//数字
					yonghuId: '',
					shenqingYuyueText: '',
					shenqingYuyueFile: '',
					insertTime: '',
					shenqingYuyueYesnoTypes: '',//数字
					shenqingYuyueYesnoValue: '',//数字对应的值
					shenqingYuyueTypes: '',//数字
					shenqingYuyueValue: '',//数字对应的值
					shenqingYuyueYesnoText: '',
					shenqingYuyueShenheTime: '',
					shenqingYuyueTime: '',
					createTime: '',
            },
            // 登陆用户信息
            user: {},
            shenqingYuyueYesnoTypesOptions: [],
            shenqingYuyueYesnoTypesIndex : 0,
            shenqingYuyueTypesOptions: [],
            shenqingYuyueTypesIndex : 0,
            yonghuOptions: [],//用户
            yonghuIndex : 0,//用户下标

        }
        },
        components: {
            wPicker
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
        async onLoad(options) {
            let yonghuParams = {
                page: 1,
                limit: 100,
            }
            let yonghuData = await this.$api.page(`yonghu`, yonghuParams);
            this.yonghuOptions = yonghuData.data.list;
		/*下拉框*/
			let shenqingYuyueYesnoTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'shenqing_yuyue_yesno_types',
            }
			let shenqingYuyueYesnoTypes = await this.$api.page(`dictionary`, shenqingYuyueYesnoTypesParams);
			this.shenqingYuyueYesnoTypesOptions = shenqingYuyueYesnoTypes.data.list
		/*下拉框*/
			let shenqingYuyueTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'shenqing_yuyue_types',
            }
			let shenqingYuyueTypes = await this.$api.page(`dictionary`, shenqingYuyueTypesParams);
			this.shenqingYuyueTypesOptions = shenqingYuyueTypes.data.list


            // 如果是更新操作
            if (options.id) {
                this.ruleForm.id = options.id;
                // 获取信息
                let res = await this.$api.info(`shenqingYuyue`, this.ruleForm.id);
                this.ruleForm = res.data;
            }
            if(options.shenqingYuyueId){
                this.ruleForm.shenqingYuyueId = options.shenqingYuyueId;
            }
            // 跨表
            // this.styleChange()
        },
        methods: {
            yonghuChange(e) {
                this.yonghuIndex = e.target.value
                this.ruleForm.yonghuName = this.yonghuOptions[this.yonghuIndex].yonghuName
                this.ruleForm.yonghuId = this.yonghuOptions[this.yonghuIndex].id
            },
            // 下拉变化
            shenqingYuyueYesnoTypesChange(e) {
                this.shenqingYuyueYesnoTypesIndex = e.target.value
                this.ruleForm.shenqingYuyueYesnoValue = this.shenqingYuyueYesnoTypesOptions[this.shenqingYuyueYesnoTypesIndex].indexName
                this.ruleForm.shenqingYuyueYesnoTypes = this.shenqingYuyueYesnoTypesOptions[this.shenqingYuyueYesnoTypesIndex].codeIndex
            },
            shenqingYuyueTypesChange(e) {
                this.shenqingYuyueTypesIndex = e.target.value
                this.ruleForm.shenqingYuyueValue = this.shenqingYuyueTypesOptions[this.shenqingYuyueTypesIndex].indexName
                this.ruleForm.shenqingYuyueTypes = this.shenqingYuyueTypesOptions[this.shenqingYuyueTypesIndex].codeIndex
            },
            // styleChange() {
            // 	this.$nextTick(() => {
            // 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
            // 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
            // 		// })
            // 	})
            // },
			shenqingYuyueFileTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.shenqingYuyueFile = 'upload/' + res.file;
                    _this.$forceUpdate();
                    _this.$nextTick(() => {
                        // _this.styleChange()
                    })
                });
            },
			// 日期控件
			insertTimeConfirm(val) {
                this.ruleForm.insertTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			shenqingYuyueShenheTimeConfirm(val) {
                this.ruleForm.shenqingYuyueShenheTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			shenqingYuyueTimeConfirm(val) {
                this.ruleForm.shenqingYuyueTime = val.result;
                this.$forceUpdate();
            },
			// 日期控件
			createTimeConfirm(val) {
                this.ruleForm.createTime = val.result;
                this.$forceUpdate();
            },

            getUUID() {
                return new Date().getTime();
            },
            async onSubmitTap() {
				if ((!this.ruleForm.shenqingYuyueUuidNumber)) {
                    this.$utils.msg(`报名编号不能为空`);
                    return
                }
				if ((!this.ruleForm.shenqingYuyueText)) {
                    this.$utils.msg(`申请理由不能为空`);
                    return
                }
				if ((!this.ruleForm.shenqingYuyueTime)) {
                    this.$utils.msg(`预约时间不能为空`);
                    return
                }
                if (this.ruleForm.id) {
                    await this.$api.update(`shenqingYuyue`, this.ruleForm);
                } else {
                    await this.$api.save(`shenqingYuyue`, this.ruleForm);
                }
                uni.setStorageSync('pingluenStateState', true);
                this.$utils.msgBack('提交成功');
            },
            getDate(type) {
                const date = new Date();
                let year = date.getFullYear();
                let month = date.getMonth() + 1;
                let day = date.getDate();
                if (type === 'start') {
                    year = year - 60;
                } else if (type === 'end') {
                    year = year + 2;
                }
                month = month > 9 ? month : '0' + month;;
                day = day > 9 ? day : '0' + day;
                return `${year}-${month}-${day}`;
            },
            toggleTab(str) {
                this.$refs[str].show();
            }
        }
    }
</script>
<style lang="scss" scoped>
    .container {
        padding: 20upx;
    }

    .content:after {
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        bottom: 0;
        content: '';
        background-attachment: fixed;
        background-size: cover;
        background-position: center;
    }

    textarea {
        border: 1upx solid #EEEEEE;
        border-radius: 20upx;
        padding: 20upx;
    }

    .title {
        width: 180upx;
    }

    .avator {
        width: 150upx;
        height: 60upx;
    }

    .right-input {
        flex: 1;
        text-align: left;
        padding: 0 24upx;
    }

    .cu-form-group.active {
        justify-content: space-between;
    }

    .cu-form-group .title {
        height: auto;
        line-height:30rpx
    }

    .btn {
        display: flex;
        align-items: center;
        justify-content: center;
        flex-wrap: wrap;
        padding: 20upx 0;
    }

    .cu-form-group {
        padding: 0 24upx;
        background-color: transparent;
        min-height: inherit;
    }

    .cu-form-group+.cu-form-group {
        border: 0;
    }

    .cu-form-group uni-input {
        padding: 0 30upx;
    }

    .uni-input {
        padding: 0 30upx;
    }

    .cu-form-group uni-textarea {
        padding: 30upx;
        margin: 0;
    }

    .cu-form-group uni-picker::after {
        line-height: 80rpx;
    }

    .select .uni-input {
        line-height: 80rpx;
    }

    .input .right-input {
        line-height: 88rpx;
    }
</style>