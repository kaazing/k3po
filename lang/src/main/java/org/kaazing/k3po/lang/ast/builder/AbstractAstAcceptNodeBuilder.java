/*
 * Copyright 2014, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaazing.k3po.lang.ast.builder;

import org.kaazing.k3po.lang.ast.AstAcceptNode;

public abstract class AbstractAstAcceptNodeBuilder<R>
    extends AbstractAstServerStreamNodeBuilder<AstAcceptNode, R> {

    public AbstractAstAcceptNodeBuilder(R result) {
        super(new AstAcceptNode(), result);
    }

    protected AbstractAstAcceptNodeBuilder(AstAcceptNode node, R result) {
        super(node, result);
    }
}