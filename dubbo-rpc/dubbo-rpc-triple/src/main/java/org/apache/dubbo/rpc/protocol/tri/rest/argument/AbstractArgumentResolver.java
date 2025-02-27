/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.rpc.protocol.tri.rest.argument;

import org.apache.dubbo.remoting.http12.HttpRequest;
import org.apache.dubbo.remoting.http12.HttpResponse;
import org.apache.dubbo.rpc.protocol.tri.rest.mapping.meta.NamedValueMeta;
import org.apache.dubbo.rpc.protocol.tri.rest.mapping.meta.ParameterMeta;

public abstract class AbstractArgumentResolver extends NamedValueArgumentResolverSupport implements ArgumentResolver {

    @Override
    public Object resolve(ParameterMeta parameter, HttpRequest request, HttpResponse response) {
        return resolve(getNamedValueMeta(parameter), request, response);
    }

    public final NamedValueMeta getNamedValueMeta(ParameterMeta parameter) {
        return cache.computeIfAbsent(parameter, k -> updateNamedValueMeta(k, createNamedValueMeta(k)));
    }

    protected abstract NamedValueMeta createNamedValueMeta(ParameterMeta parameter);
}
