<template>
  <div>
    <div class="search-bar">
      <input type="text" name="search" class="search" />
      <button>查询</button>
    </div>
    <div class="content">
    </div>
  </div>
</template>

<style>
  .search-bar {
    border-bottom: 1px solid #F8F8F8;
    padding: 3px 0;
    display: flex;
  }
  .search-bar .search, .search-bar .search:focus {
    border: none;
    outline: none;
    flex: 1;
  }
  .search-bar button {
    border: none;
    padding: 5px 20px;
    border-radius: 5px;
  }
</style>
