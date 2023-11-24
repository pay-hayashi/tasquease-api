package net.pancake_tor.tasquease.infrastructure.mapper

import net.pancake_tor.tasquease.infrastructure.resource.StoryResource
import org.apache.ibatis.annotations.*
import org.apache.ibatis.builder.annotation.ProviderMethodResolver
import org.apache.ibatis.jdbc.SQL

@Mapper
interface StoryMapper {

    @SelectProvider(StorySqlProvider::class)
    fun findOne(id: Int): StoryResource?

    @SelectProvider(StorySqlProvider::class)
    fun findAll(): List<StoryResource>

    @InsertProvider(StorySqlProvider::class)
    fun insert(story: StoryResource)

    @UpdateProvider(StorySqlProvider::class)
    fun update(story: StoryResource)

    @DeleteProvider(StorySqlProvider::class)
    fun delete(id: Int)

    class StorySqlProvider : ProviderMethodResolver {

        private val STORY = "story"

        fun findOne(id: Int): String {
            return SQL()
                .SELECT("id, title, description, tags, created_at, created_by, updated_at, updated_by")
                .FROM(STORY)
                .WHERE("id = #{id}")
                .toString()
        }

        fun findAll(): String {
            return SQL()
                .SELECT("id, title, description, tags, created_at, created_by, updated_at, updated_by")
                .FROM(STORY)
                .toString()
        }

        fun insert(story: StoryResource): String {
            return SQL()
                .INSERT_INTO(STORY)
                .VALUES("title", "#{title}")
                .VALUES("description", "#{description}")
                .VALUES("tags", "#{tags}")
                .VALUES("created_by", "#{createdBy}")
                .VALUES("updated_by", "#{updatedBy}")
                .toString()
        }

        fun update(story: StoryResource): String {
            return SQL()
                .UPDATE(STORY)
                .SET("title = #{title}")
                .SET("description = #{description}")
                .SET("tags = #{tags}")
                .SET("updated_by = #{updatedBy}")
                .WHERE("id = #{id}")
                .toString()
        }

        fun delete(id: Int): String {
            return SQL()
                .DELETE_FROM(STORY)
                .WHERE("id = #{id}")
                .toString()
        }
    }
}
