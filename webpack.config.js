'use strict'
const path = require('path')
const webpack = require('webpack')
const UglifyJsPlugin = require('uglifyjs-webpack-plugin')



const CleanWebpackPlugin = require('clean-webpack-plugin')
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin
const HtmlWebpackPlugin = require('html-webpack-plugin')
const os = require('os')
const ProgressBarPlugin = require('progress-bar-webpack-plugin')
const SpeedMeasurePlugin = require("speed-measure-webpack-plugin")
const FirendlyErrorePlugin = require('friendly-errors-webpack-plugin')

const AddAssetHtmlPlugin = require('add-asset-html-webpack-plugin')

const HappyPack = require("happypack");

var nodeModulesPath = path.join(__dirname, '/node_modules');



const HappyThreadPool = HappyPack.ThreadPool({ size: os.cpus().length })
const ThreadsNumber = os.cpus().length/2
module.exports = (env) => {
  console.log('WEBPACK ENV:', env,os.cpus().length)

  // VARIABLES
  const isProduction = env === 'production'
  const isDev = env === 'development'

  //// PLUGGINS ////

  // cleans 'dist' folder everytime before a new build
  const CleanPLugin = new CleanWebpackPlugin(['dist'], {
    root: __dirname,
    verbose: true,
    dry: false
  })

  const AnalyzerPlugin = new BundleAnalyzerPlugin({
    analyzerMode: 'static',
    openAnalyzer: false


  })

  
  let htmlArr = [
  new HtmlWebpackPlugin({
    title: "教务系统简版",

    chunks: [ `index`], //引入的js
    template: "./template.html",
    filename: "index.html",
    favicon:'./style/img/favicon.ico',
    inject: true,

    minify: {//压缩html
      collapseWhitespace: true,
      preserveLineBreaks: true
    },
  })
  ]
  const firendlyErrorePlugin = new FirendlyErrorePlugin()
  const happypackPluginArr = [
    new HappyPack({
      // 用唯一的标识符id来代表当前的HappyPack 处理一类特定的文件
      id: 'babel',
      // 如何处理.js文件，用法和Loader配置是一样的
      threads:ThreadsNumber,

      loaders: [{
        loader: 'babel-loader',
        cache: true,

        threadPool: HappyThreadPool,
      
        options:{
          "presets": [
            [
              "env",
              {
                targets: {
                    "chrome": "58",
                    "ie": "11"
                },
                useBuiltIns: "usage"
              }
             
            ],
            [
              "react",
             
            ],
            [
              "stage-0"
            ]
          ],
        
          "plugins": [
        
            ["transform-decorators-legacy"],
            ["transform-class-properties"],
            [
              "transform-runtime",{ polyfill: false }
            ],
            [
              "syntax-dynamic-import"
            ],
            ["import",
              {
                "libraryName": "antd",
                "libraryDirectory": "es",
                "style": true
              }
            ],
            ["import", { "libraryName": "antd-mobile","libraryDirectory": "es", "style": "css" }] // `style: true` 会加载 less 文件
        
          ]
        
        }
      }],
     

    }),
    

  ]
  // BUILDING WEBPACK
  const config = {
    externals: {
    }
  }

  // config.entry = ['babel-polyfill', './src/app.js']
  config.entry = {

    "index": './src/admin.js'
  }
  config.output = {
    path: path.join(__dirname, '/dist'),
    filename: 'bundle.js'
  }

  config.optimization = {
    // splitChunks: {
    //   cacheGroups: {
    //     commons: {
    //       test: /[\\/]node_modules[\\/]/,
    //       name: 'vendor',
    //       chunks: 'initial'
    //     }
    //   }
    // },
    // runtimeChunk: {
    //   name: 'manifest'
    // },
    minimizer: [
      new UglifyJsPlugin({
        sourceMap: true,
        uglifyOptions: {
          ecma: 8,
          mangle: false,
          keep_classnames: true,
          keep_fnames: true,
          compress:{
            warnings:false,
            drop_console:true
        }


        },
        parallel: true,
      })
    ]
  }
  const progressBarPlugin = new ProgressBarPlugin()
  const speedMeasurePlugin = new SpeedMeasurePlugin()
  // config.plugins = [CleanPLugin, AnalyzerPlugin, HTMLPlugin]
  config.plugins = [

    CleanPLugin,
    ...happypackPluginArr,
    ...htmlArr,
    progressBarPlugin,
    speedMeasurePlugin,
    firendlyErrorePlugin,
    // AnalyzerPlugin,
   

    new webpack.ProvidePlugin({
      $:"jquery",
      jQuery:"jquery",
      "window.jQuery":"jquery"
  }),
  new webpack.DllReferencePlugin({
    // 描述 vendor 动态链接库的文件内容
    manifest: require('./public/vendor/vendor.manifest.json'),
    context: __dirname
  }),
  // 该插件将把给定的 JS 或 CSS 文件添加到 webpack 配置的文件中，并将其放入资源列表 html webpack插件注入到生成的 html 中。
  new AddAssetHtmlPlugin([
    {
      // 要添加到编译中的文件的绝对路径，以及生成的HTML文件。支持 globby 字符串
      filepath: require.resolve(path.resolve(__dirname, './public/vendor/vendor.dll.js')),
      // 文件输出目录
      outputPath: 'vendor',
      // 脚本或链接标记的公共路径
      publicPath: 'vendor'
    }
  ]),
      
  ]

  config.module = {

    rules: [
      // {
      //   test: /\.(js|jsx)$/,
      //   loader: 'babel-loader',
      //   exclude: /node_modules/,

      // },
      {
        test: /\.(js|jsx)$/,
        // 将对.js文件的处理转交给id为babel的HappyPack的实列
        use: ['happypack/loader?id=babel'],
        // loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.(png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot|otf|mp4)$/,
        loader: 'file-loader',
        exclude: /node_modules/


      },
      
      {
        test: /\.css$/,


        use: ['style-loader', 'css-loader'],
        // use: ['happypack/loader?id=css'],


      },
      {
        test: /\.less/,


        // use: ['happypack/loader?id=less'],
        use: [

        {
            loader: 'style-loader'
        },
        {
            loader: 'css-loader',

        },
        {
            loader: 'less-loader',
            options: {
                javascriptEnabled: true
            }
        },
        

        ]
      },

    ]
  }

  config.resolve = {
    extensions: ['.js', '.jsx']
  }

  if (isProduction) {
    config.output = {
      path: path.join(__dirname, 'dist'),
      chunkFilename: '[name].[chunkhash].bundle.js',
      filename: '[name].[chunkhash].bundle.js'
      // chunkFilename: '[name].bundle.js',
      // filename: '[name].bundle.js'
    }
    config.mode = 'production'
    config.devtool = 'none'
    // config.devtool = 'cheap-source-map'

    
  }

  if (isDev) {
    config.output = {
      path: path.join(__dirname, 'dist'),
      chunkFilename: '[name].bundle.js',
      filename: '[name].bundle.js'
    }

    config.mode = 'development'
    config.devtool = 'inline-source-map'

    config.devServer = {
      contentBase: path.join(__dirname, 'dist'),
      historyApiFallback: true,
      host: 'localhost',
      port: 8520,
      overlay: true,
      inline: true,
      open: false,
      hot: true
    }

  }


  return config
}
