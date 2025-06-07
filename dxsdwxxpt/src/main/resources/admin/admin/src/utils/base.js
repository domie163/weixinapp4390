const base = {
    get() {
        return {
            url : "http://localhost:8080/dxsdwxxpt/",
            name: "dxsdwxxpt",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/dxsdwxxpt/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "大学生党务学习平台"
        } 
    }
}
export default base
