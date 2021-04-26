 <template>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="time"
        label="日期">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名">
      </el-table-column>
      <el-table-column
        prop="phoneNum"
        label="账号">
      </el-table-column>
      <el-table-column
        prop="detailed"
        label="详情">
      </el-table-column>
    </el-table>
  </template>

  <script>
    export default {
      data() {
        return {
          tableData: JSON.parse(sessionStorage.getItem("record"))
        }
      }
    }
  </script>