package net.pancake_tor.tasquease.infrastructure.mapper

import net.pancake_tor.tasquease.infrastructure.command.TaskCommand
import net.pancake_tor.tasquease.infrastructure.resource.TaskResource
import org.apache.ibatis.annotations.*
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL

@Mapper
interface TaskMapper {

    @SelectProvider(TaskSqlProvider::class)
    fun findOne(id: Int): TaskResource?

    @SelectProvider(TaskSqlProvider::class)
    fun findByStoryId(storyId: Int): List<TaskResource>

    @InsertProvider(TaskSqlProvider::class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(task: TaskCommand)

    @UpdateProvider(TaskSqlProvider::class)
    fun update(task: TaskCommand)

    @DeleteProvider(TaskSqlProvider::class)
    fun delete(id: Int)

    class TaskSqlProvider : ProviderMethodResolver {

        private val TASK = "task"

        fun findOne(id: Int): String {
            return SQL()
                .SELECT("id, story_id, title, description, tags, created_at, created_by, updated_at, updated_by")
                .FROM(TASK)
                .WHERE("id = #{id}")
                .toString()
        }

        fun findByStoryId(storyId: Int): String {
            return SQL()
                .SELECT("id, story_id, title, description, tags, created_at, created_by, updated_at, updated_by")
                .FROM(TASK)
                .WHERE("story_id = #{storyId}")
                .toString()
        }

        fun insert(task: TaskCommand): String {
            return SQL()
                .INSERT_INTO(TASK)
                .VALUES("story_id", "#{storyId}")
                .VALUES("title", "#{title}")
                .VALUES("description", "#{description}")
                .VALUES("tags", "#{tags}")
                .VALUES("created_at", "NOW()")
                .VALUES("created_by", "#{modifiedBy}")
                .VALUES("updated_at", "NOW()")
                .VALUES("updated_by", "#{modifiedBy}")
                .toString()
        }

        fun update(task: TaskCommand): String {
            return SQL()
                .UPDATE(TASK)
                .SET("story_id = #{storyId}")
                .SET("title = #{title}")
                .SET("description = #{description}")
                .SET("tags = #{tags}")
                .SET("updated_at = NOW()")
                .SET("updated_by = #{modifiedBy}")
                .WHERE("id = #{id}")
                .toString()
        }

        fun delete(id: Int): String {
            return SQL()
                .DELETE_FROM(TASK)
                .WHERE("id = #{id}")
                .toString()
        }
    }
}
