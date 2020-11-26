<template>
  <div class="center-body">
    <Toolbar></Toolbar>
    <div class="center-content">
      Hello
    </div>
  </div>
</template> 

<script>
  import Toolbar from '../Toolbar/index.vue'

  export default {
    components: { Toolbar }
  }
</script>

<style>
  .center-body {
    display: flex;
    flex-direction: column;
  }
  .center-body .center-content {
    flex: 1;
  }
</style>
