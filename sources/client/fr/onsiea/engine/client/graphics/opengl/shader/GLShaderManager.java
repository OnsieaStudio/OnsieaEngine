/**
* Copyright 2021 Onsiea All rights reserved.<br><br>
*
* This file is part of Onsiea Engine project. (https://github.com/Onsiea/OnsieaEngine)<br><br>
*
* Onsiea Engine is [licensed] (https://github.com/Onsiea/OnsieaEngine/blob/main/LICENSE) under the terms of the "GNU General Public Lesser License v3.0" (GPL-3.0).
* https://github.com/Onsiea/OnsieaEngine/wiki/License#license-and-copyright<br><br>
*
* Onsiea Engine is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3.0 of the License, or
* (at your option) any later version.<br><br>
*
* Onsiea Engine is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Lesser General Public License for more details.<br><br>
*
* You should have received a copy of the GNU Lesser General Public License
* along with Onsiea Engine.  If not, see <https://www.gnu.org/licenses/>.<br><br>
*
* Neither the name "Onsiea", "Onsiea Engine", or any derivative name or the names of its authors / contributors may be used to endorse or promote products derived from this software and even less to name another project or other work without clear and precise permissions written in advance.<br><br>
*
* @Author : Seynax (https://github.com/seynax)<br>
* @Organization : Onsiea Studio (https://github.com/Onsiea)
*/
package fr.onsiea.engine.client.graphics.opengl.shader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Seynax
 *
 */
public class GLShaderManager
{
	private final Map<String, Shader>	shaders;

	private ShaderBasic					shaderBasic;

	public GLShaderManager()
	{
		this.shaders = new HashMap<>();

		try
		{
			this.add("basic", this.shaderBasic = new ShaderBasic());
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	public GLShaderManager add(String nameIn, Shader shaderIn)
	{
		this.shaders.put(nameIn, shaderIn);

		return this;
	}

	public Shader get(String nameIn)
	{
		return this.shaders.get(nameIn);
	}

	public boolean contains(String nameIn)
	{
		return this.shaders.containsKey(nameIn);
	}

	public GLShaderManager remove(String nameIn)
	{
		this.shaders.remove(nameIn);

		return this;
	}

	/**
	 *
	 */
	public void cleanup()
	{
		for (final Shader shader : this.shaders.values())
		{
			shader.cleanup();
		}
	}

	public final Map<String, Shader> shaders()
	{
		return this.shaders;
	}

	public final Map<String, Shader> getShaders()
	{
		return this.shaders;
	}

	public final ShaderBasic shaderBasic()
	{
		return this.shaderBasic;
	}
}