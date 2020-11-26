<template>
  <LeftPanel class="left-panel" :class="{cover: !!adjusterOffset}" :style="{width: (hiddenWidth > 0 ? hiddenWidth : leftWidth) +  'px'}" @hidden="onHiddenEvent" />
  <div class="adjuster" @mousedown="onAdjusterEnterEvent" v-show="hiddenWidth <= 0"></div>
  <CenterPanel class="center-panel" :class="{cover: !!adjusterOffset}" />
</template>

<script>
import LeftPanel from './components/LeftPanel/index.vue'
import CenterPanel from './components/CenterPanel/index.vue'

export default {
  name: 'App',
  components: {
    LeftPanel, CenterPanel
  },
  data () {
    return {
      socket: undefined,
      leftWidth: 500,
      adjusterOffset: undefined,
      hiddenWidth: 0
    }
  },
  methods: {
    init () {
      if (this.socket) {
        this.socket.close()
        this.socket = undefined
      }
      this.socket = new WebSocket('ws://127.0.0.1:8080/backend')
      this.socket.onopen = this.socketOpenEvent
      this.socket.onmessage = this.socketMessageEvent
      this.socket.onclose = this.socketCloseEvent
      this.socket.onerror = this.socketErrorEvent
    },
    socketOpenEvent() {
      console.log('Socket 打开')
      this.socket.send('WebSocket send......')
    },
    socketMessageEvent (message) {
      console.log('Message:', message)
    },
    socketCloseEvent() {
      console.log('Socket 关闭')
      this.socket = undefined
    },
    socketErrorEvent() {
      console.log('Socket 错误')
      this.socket = undefined
    },
    onAdjusterEnterEvent (evt) {
      window.addEventListener('mousemove', this.onAdjusterMoveEvent, true)
      window.addEventListener('mouseup', this.onAdjusterEndEvent, true)
      this.adjusterOffset = [this.leftWidth, evt.screenX]
    },
    onAdjusterMoveEvent (evt) {
      evt.preventDefault()
      evt.stopPropagation()
      if (this.adjusterOffset) {
        this.leftWidth = Math.max(100, this.adjusterOffset[0] + (evt.screenX - this.adjusterOffset[1]))
      }
    },
    onAdjusterEndEvent () {
      this.adjusterOffset = undefined
      window.removeEventListener('movemove', this.onAdjusterMoveEvent)
      window.removeEventListener('mouseup', this.onAdjusterEndEvent)
    },
    onHiddenEvent (hiddenWidth) {
      this.hiddenWidth = hiddenWidth
    }
  },
  created () {
    // this.init()
    this.leftWidth = window.innerWidth / 3;
  }
}
</script>

<style>
  .adjuster { width: 5px; height: 100%; background: #EEEEEE; }
  .adjuster:hover { cursor: ew-resize; }

  [class$=panel] {
    position: relative;
  }
  .cover::after {
    content: '';
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
  }
</style>
