const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      // /api 및 /api/* 요청에 대해 프록시 설정
      '/book': {
        "target": 'https://www.aladin.co.kr',
        "pathRewrite": { '^/book': '' },
        "changeOrigin": true,
        "secure": false
      },
    },
  },
})
