package spring.grpc.kt.starter.springgrpcktstarter.controller

import org.lognet.springboot.grpc.GRpcService
import spring.grpc.kt.starter.v1.ServiceGrpcKt
import spring.grpc.kt.starter.v1.ServiceOuterClass
import kotlin.coroutines.EmptyCoroutineContext

@GRpcService
class ServiceController : ServiceGrpcKt.ServiceCoroutineImplBase(
    coroutineContext = EmptyCoroutineContext
) {
    override suspend fun service(request: ServiceOuterClass.ServiceRequest): ServiceOuterClass.ServiceResponse {
        return super.service(request)
    }
}