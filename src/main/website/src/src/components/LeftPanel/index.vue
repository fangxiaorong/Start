<template>
  <div class="side-body">
    <div class="side-bar">
      <div v-for="plugin in plugins" :key="plugin.name" v-text="plugin.vname" :class="{active: this.currentPlugin && this.currentPlugin.name == plugin.name}" @click="onTabClickAction(plugin)"></div>

      <div class="bottom" @click="onHiddenClickAction">Hidden</div>
    </div>
    <div class="side-content" v-if="!isHiddenSide">
      <keep-alive>
        <component :is="currentPlugin ? currentPlugin.component : emptyPlugin" class="component" />
      </keep-alive>
    </div>
  </div>
</template>

<script>
  import EmptyPlugin from './EmptyPlugin.vue'
  import WebViewPlugin from './WebViewPlugin.vue'
  import JavaPackagePlugin from './JavaPackagePlugin.vue'
  import DocumentPlugin from './DocumentPlugin.vue'

  export default {
    components: { EmptyPlugin, WebViewPlugin, JavaPackagePlugin, DocumentPlugin },
    props: {
      emptyPlugin: {
        type: String,
        default: 'EmptyPlugin'
      }
    },
    computed: {
    },
    data () {
      return {
        plugins: [],
        currentPlugin: undefined,
        isHiddenSide: false
      }
    },
    methods: {
      register (name, vname, component) {
        this.plugins.push({name, vname, component})
      },
      onTabClickAction (plugin) {
        this.currentPlugin = plugin
      },
      onHiddenClickAction () {
        this.isHiddenSide = !this.isHiddenSide
        this.$emit('hidden', this.isHiddenSide ? document.querySelector('.side-bar').offsetWidth : 0)
      }
    },
    created () {
      this.register('WebView', '浏览器', 'WebViewPlugin')
      this.register('JavaPackage', '包管理', 'JavaPackagePlugin')
      this.register('Document', '文档', 'DocumentPlugin')
    }
  }
</script>

<style scoped>
  .side-body {
    display: flex;
  }
  .side-body .side-bar {
    display: flex;
    flex-direction: row;
    writing-mode: vertical-lr;
    border-right: 1px solid #F0F0F0;
    height: 100%;
  }
  .side-body .side-bar > div {
    padding: 10px;
    border-bottom: 1px solid #F0F0F0;
  }
  .side-body .side-bar > div.active {
    background: #F0F0F0;
  }
  .side-body .side-bar .bottom {
    position: absolute;
    bottom: 0;
    border-top: 1px solid #F0F0F0;
  }
  .side-body .side-content {
    flex: 1;
    height: 100%;
    overflow: hidden;
  }
  .side-body .side-content .component {
    height: 100%;
    width: 100%;
  }
</style>
