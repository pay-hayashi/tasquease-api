package net.pancake_tor.tasquease.domain.exception

import org.apache.ibatis.javassist.NotFoundException

class NotFoundStoryException() : NotFoundException("Story not found.")
