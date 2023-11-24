package net.pancake_tor.tasquease.domain.exception

import org.apache.ibatis.javassist.NotFoundException

class NotFoundTaskException() : NotFoundException("Task not found.")
