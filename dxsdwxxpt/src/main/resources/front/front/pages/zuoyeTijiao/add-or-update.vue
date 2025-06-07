<template>
	<view class="content">
		<form class="app-update-pv">
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">作业</view>
				<picker @change="zuoyeChange" :value="zuoyeIndex" :range="zuoyeOptions" range-key="zuoyeName">
					<view
						:style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
						class="uni-input">{{ruleForm.zuoyeId?ruleForm.zuoyeName:"请选择作业"}}</view>
				</picker>
			</view>''
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">党务工作者</view>
				<picker @change="gongzuoChange" :value="gongzuoIndex" :range="gongzuoOptions" range-key="gongzuoName">
					<view
						:style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
						class="uni-input">{{ruleForm.gongzuoId?ruleForm.gongzuoName:"请选择党务工作者"}}</view>
				</picker>
			</view>
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
					class="title">报名唯一编号</view>
				<input disabled
					:style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					:disabled="ro.zuoyeTijiaoUuidNumber" type="text" v-model="ruleForm.zuoyeTijiaoUuidNumber"
					placeholder="报名唯一编号"></input>
			</view>
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">内容</view>
				<textarea
					:style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
					:disabled="ro.zuoyeTijiaoText" v-model="ruleForm.zuoyeTijiaoText" placeholder="内容" />
			</view>
			<view
				:style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(218, 220, 219, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"108rpx"}'
				class="cu-form-group" @tap="zuoyeShangchuanFileTap">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">作业上传</view>
				<view class="right-input" style="padding:0;textAlign:left">
					<image
						:style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
						class="avator" v-if="ruleForm.zuoyeShangchuanFile" :src="baseUrl+ruleForm.zuoyeShangchuanFile"
						mode="aspectFill">
					</image>
					<image
						:style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
						class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
				</view>
			</view>
			<!-- <view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">批改分数</view>
				<input disabled
					:style='{"padding":"0 30rpx","boxShadow":"0 0 16rpx var(--publicSubColor) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"var(--publicMainColor)","borderRadius":"20rpx","color":"var(--publicMainColor)","textAlign":"left","borderWidth":"2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					:disabled="ro.zuoyeTijiaoPigai" type="number" v-model="ruleForm.zuoyeTijiaoPigai"
					placeholder="批改分数"></input>
			</view> -->

			<view class="btn">
				<button
					:style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"var(--publicMainColor)","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
					@tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
			ref="insertTime" themeColor="#333333"></w-picker>
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
				ro: {
					zuoyeTijiaoUuidNumber: true,
					zuoyeId: false,
					gongzuoId: false,
					yonghuId: false,
					zuoyeTijiaoText: false,
					zuoyeShangchuanFile: false,
					zuoyeTijiaoYesnoTypes: false,
					zuoyeTijiaoPigai: false,
					insertTime: false,
					createTime: false,
				},
				ruleForm: {
					zuoyeTijiaoUuidNumber: this.getUUID(), //数字
					zuoyeId: '',
					gongzuoId: '',
					yonghuId: '',
					zuoyeTijiaoText: '',
					zuoyeShangchuanFile: '',
					zuoyeTijiaoYesnoTypes: '', //数字
					zuoyeTijiaoYesnoValue: '', //数字对应的值
					zuoyeTijiaoPigai: '',
					insertTime: '',
					createTime: '',
				},
				// 登陆用户信息
				user: {},
				zuoyeTijiaoYesnoTypesOptions: [],
				zuoyeTijiaoYesnoTypesIndex: 0,
				zuoyeOptions: [], //作业
				zuoyeIndex: 0, //作业下标
				gongzuoOptions: [], //党务工作者
				gongzuoIndex: 0, //党务工作者下标
				yonghuOptions: [], //用户
				yonghuIndex: 0, //用户下标

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
			let zuoyeParams = {
				page: 1,
				limit: 100,
			}
			let zuoyeData = await this.$api.page(`zuoye`, zuoyeParams);
			this.zuoyeOptions = zuoyeData.data.list;
			let gongzuoParams = {
				page: 1,
				limit: 100,
			}
			let gongzuoData = await this.$api.page(`gongzuo`, gongzuoParams);
			this.gongzuoOptions = gongzuoData.data.list;
			let yonghuParams = {
				page: 1,
				limit: 100,
			}
			let yonghuData = await this.$api.page(`yonghu`, yonghuParams);
			this.yonghuOptions = yonghuData.data.list;
			/*下拉框*/
			let zuoyeTijiaoYesnoTypesParams = {
				page: 1,
				limit: 100,
				dicCode: 'zuoye_tijiao_yesno_types',
			}
			let zuoyeTijiaoYesnoTypes = await this.$api.page(`dictionary`, zuoyeTijiaoYesnoTypesParams);
			this.zuoyeTijiaoYesnoTypesOptions = zuoyeTijiaoYesnoTypes.data.list


			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				let res = await this.$api.info(`zuoyeTijiao`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			if (options.zuoyeTijiaoId) {
				this.ruleForm.zuoyeTijiaoId = options.zuoyeTijiaoId;
			}
			// 跨表
			// this.styleChange()
		},
		methods: {
			zuoyeChange(e) {
				this.zuoyeIndex = e.target.value
				this.ruleForm.zuoyeName = this.zuoyeOptions[this.zuoyeIndex].zuoyeName
				this.ruleForm.zuoyeId = this.zuoyeOptions[this.zuoyeIndex].id
			},
			gongzuoChange(e) {
				this.gongzuoIndex = e.target.value
				this.ruleForm.gongzuoName = this.gongzuoOptions[this.gongzuoIndex].gongzuoName
				this.ruleForm.gongzuoId = this.gongzuoOptions[this.gongzuoIndex].id
			},
			yonghuChange(e) {
				this.yonghuIndex = e.target.value
				this.ruleForm.yonghuName = this.yonghuOptions[this.yonghuIndex].yonghuName
				this.ruleForm.yonghuId = this.yonghuOptions[this.yonghuIndex].id
			},
			// 下拉变化
			zuoyeTijiaoYesnoTypesChange(e) {
				this.zuoyeTijiaoYesnoTypesIndex = e.target.value
				this.ruleForm.zuoyeTijiaoYesnoValue = this.zuoyeTijiaoYesnoTypesOptions[this.zuoyeTijiaoYesnoTypesIndex]
					.indexName
				this.ruleForm.zuoyeTijiaoYesnoTypes = this.zuoyeTijiaoYesnoTypesOptions[this.zuoyeTijiaoYesnoTypesIndex]
					.codeIndex
			},
			// styleChange() {
			// 	this.$nextTick(() => {
			// 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
			// 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
			// 		// })
			// 	})
			// },
			zuoyeShangchuanFileTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.zuoyeShangchuanFile = 'upload/' + res.file;
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
			createTimeConfirm(val) {
				this.ruleForm.createTime = val.result;
				this.$forceUpdate();
			},

			getUUID() {
				return new Date().getTime();
			},
			async onSubmitTap() {
				if ((!this.ruleForm.zuoyeTijiaoUuidNumber)) {
					this.$utils.msg(`报名唯一编号不能为空`);
					return
				}
				if ((!this.ruleForm.zuoyeTijiaoText)) {
					this.$utils.msg(`内容不能为空`);
					return
				}
				// if ((!this.ruleForm.zuoyeTijiaoPigai) && (!this.$validate.isIntNumer(this.ruleForm
				// 		.zuoyeTijiaoPigai)) && this.ruleForm.zuoyeTijiaoPigai > 0) {
				// 	this.$utils.msg(`批改分数不能为空，不能小于0 格式为数字`);
				// 	return
				// }
				if (this.ruleForm.id) {
					await this.$api.update(`zuoyeTijiao`, this.ruleForm);
				} else {
					await this.$api.save(`zuoyeTijiao`, this.ruleForm);
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
		line-height: 30rpx
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